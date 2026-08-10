#!/usr/bin/env node

const fs = require("fs");
const path = require("path");

const ROOT = process.cwd();
const README_PATH = path.join(ROOT, "README.md");

const AUTO_START = "<!-- AUTO-GENERATED:START -->";
const AUTO_END = "<!-- AUTO-GENERATED:END -->";

const DIFFICULTIES = ["Easy", "Medium", "Hard"];

function isSolvedDir(name) {
  return /^\d{4}-.+/.test(name);
}

function detectPlatformFromPath(folderName, readmeContent) {
  const lc = `${folderName}`.toLowerCase();
  const content = (readmeContent || "").toLowerCase();

  if (content.includes("leetcode.com")) return "LeetCode";
  if (content.includes("geeksforgeeks")) return "GeeksforGeeks";
  if (content.includes("hackerrank")) return "HackerRank";

  if (lc.includes("gfg") || lc.includes("geeksforgeeks")) return "GeeksforGeeks";
  if (lc.includes("hackerrank")) return "HackerRank";
  return "LeetCode";
}

function detectDifficulty(readmeContent) {
  const text = readmeContent || "";
  for (const d of DIFFICULTIES) {
    const regex = new RegExp(`<h3>\\s*${d}\\s*</h3>`, "i");
    if (regex.test(text)) return d;
  }

  const lower = text.toLowerCase();
  if (lower.includes("easy")) return "Easy";
  if (lower.includes("medium")) return "Medium";
  if (lower.includes("hard")) return "Hard";
  return "Unknown";
}

function toTitleFromSlug(folderName) {
  const cleaned = folderName.replace(/^\d{4}-/, "");
  return cleaned
    .split("-")
    .filter(Boolean)
    .map((w) => w.charAt(0).toUpperCase() + w.slice(1))
    .join(" ");
}

function getRepoSlug() {
  const githubRepo = process.env.GITHUB_REPOSITORY;
  if (githubRepo && githubRepo.includes("/")) return githubRepo;

  try {
    const gitConfig = fs.readFileSync(path.join(ROOT, ".git", "config"), "utf8");
    const m = gitConfig.match(/url\s*=\s*https:\/\/github\.com\/([^\s]+?)(?:\.git)?\s*$/m)
      || gitConfig.match(/url\s*=\s*git@github\.com:([^\s]+?)(?:\.git)?\s*$/m);
    if (m?.[1]) return m[1];
  } catch (_) {}

  return "Syed-Aadil-Sameer-M/Leetcode-GFG-HackerRank-JAVA_Implementation";
}

function collectSolvedQuestions() {
  const entries = fs.readdirSync(ROOT, { withFileTypes: true });
  const solvedDirs = entries.filter((e) => e.isDirectory() && isSolvedDir(e.name));

  const all = [];

  for (const dir of solvedDirs) {
    const folder = dir.name;
    const readmePath = path.join(ROOT, folder, "README.md");
    const hasReadme = fs.existsSync(readmePath);
    const readmeContent = hasReadme ? fs.readFileSync(readmePath, "utf8") : "";

    const difficulty = detectDifficulty(readmeContent);
    const platform = detectPlatformFromPath(folder, readmeContent);

    const idMatch = folder.match(/^(\d{4})-/);
    const id = idMatch ? Number(idMatch[1]) : Number.MAX_SAFE_INTEGER;

    all.push({
      id,
      folder,
      title: toTitleFromSlug(folder),
      difficulty,
      platform,
      path: folder,
    });
  }

  all.sort((a, b) => a.id - b.id || a.folder.localeCompare(b.folder));
  return all;
}

function summarize(items) {
  const diffCounts = { Easy: 0, Medium: 0, Hard: 0, Unknown: 0 };
  const platforms = {
    LeetCode: { total: 0, Easy: 0, Medium: 0, Hard: 0 },
    GeeksforGeeks: { total: 0, Easy: 0, Medium: 0, Hard: 0 },
    HackerRank: { total: 0, Easy: 0, Medium: 0, Hard: 0 },
  };

  for (const q of items) {
    if (!(q.difficulty in diffCounts)) diffCounts.Unknown++;
    else diffCounts[q.difficulty]++;

    if (!platforms[q.platform]) {
      platforms[q.platform] = { total: 0, Easy: 0, Medium: 0, Hard: 0 };
    }

    platforms[q.platform].total++;
    if (q.difficulty === "Easy" || q.difficulty === "Medium" || q.difficulty === "Hard") {
      platforms[q.platform][q.difficulty]++;
    }
  }

  return { diffCounts, platforms };
}

function badge(total) {
  return `https://img.shields.io/badge/Problems%20Solved-${total}-brightgreen?style=flat-square`;
}

function buildGeneratedSection(items, repoSlug) {
  const { diffCounts, platforms } = summarize(items);
  const total = items.length;

  const lines = [];
  lines.push(AUTO_START);
  lines.push("## 🤖 Auto-generated Progress Dashboard");
  lines.push("");
  lines.push(`- Last generated: ${new Date().toISOString()}`);
  lines.push(`- Total solved: **${total}**`);
  lines.push("");
  lines.push("### Difficulty Stats");
  lines.push("");
  lines.push("| Difficulty | Count |");
  lines.push("|---|---:|");
  lines.push(`| Easy | ${diffCounts.Easy} |`);
  lines.push(`| Medium | ${diffCounts.Medium} |`);
  lines.push(`| Hard | ${diffCounts.Hard} |`);
  if (diffCounts.Unknown > 0) lines.push(`| Unknown | ${diffCounts.Unknown} |`);
  lines.push("");

  lines.push("### Platform Stats");
  lines.push("");
  lines.push("| Platform | Total | Easy | Medium | Hard |");
  lines.push("|---|---:|---:|---:|---:|");

  for (const p of ["LeetCode", "GeeksforGeeks", "HackerRank"]) {
    const x = platforms[p] || { total: 0, Easy: 0, Medium: 0, Hard: 0 };
    lines.push(`| ${p} | ${x.total} | ${x.Easy} | ${x.Medium} | ${x.Hard} |`);
  }

  lines.push("");
  lines.push("### Solved Questions");
  lines.push("");
  lines.push("| # | Question | Difficulty | Platform |");
  lines.push("|---:|---|---|---|");

  items.forEach((q, idx) => {
    const url = `https://github.com/${repoSlug}/tree/main/${q.path}`;
    const diffEmoji = q.difficulty === "Easy" ? "🟢 Easy" : q.difficulty === "Medium" ? "🟡 Medium" : q.difficulty === "Hard" ? "🔴 Hard" : "⚪ Unknown";
    lines.push(`| ${idx + 1} | [${q.folder}](${url}) | ${diffEmoji} | ${q.platform} |`);
  });

  lines.push("");
  lines.push("### Dynamic Badge");
  lines.push("");
  lines.push(`![Problems Solved](${badge(total)})`);
  lines.push(AUTO_END);
  lines.push("");

  return lines.join("\n");
}

function injectGeneratedSection(originalReadme, generated) {
  if (originalReadme.includes(AUTO_START) && originalReadme.includes(AUTO_END)) {
    const start = originalReadme.indexOf(AUTO_START);
    const end = originalReadme.indexOf(AUTO_END) + AUTO_END.length;
    return originalReadme.slice(0, start) + generated + originalReadme.slice(end);
  }

  const marker = "## 🔄 Update This README Dynamically";
  if (originalReadme.includes(marker)) {
    return originalReadme.replace(marker, `${generated}\n${marker}`);
  }

  return `${generated}\n${originalReadme}`;
}

function main() {
  if (!fs.existsSync(README_PATH)) {
    throw new Error("README.md not found in repository root.");
  }

  const repoSlug = getRepoSlug();
  const readme = fs.readFileSync(README_PATH, "utf8");
  const questions = collectSolvedQuestions();
  const generated = buildGeneratedSection(questions, repoSlug);
  const next = injectGeneratedSection(readme, generated);

  if (next !== readme) {
    fs.writeFileSync(README_PATH, next, "utf8");
    console.log("README.md updated successfully.");
  } else {
    console.log("README.md already up-to-date.");
  }
}

main();
