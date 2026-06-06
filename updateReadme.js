const fs = require('fs');
const path = require('path');

// Helper function to extract difficulty from README
function extractDifficultyFromReadme(problemDir) {
  const readmePath = path.join(problemDir, 'README.md');
  if (fs.existsSync(readmePath)) {
    const content = fs.readFileSync(readmePath, 'utf8');
    if (content.includes('<h3>Hard</h3>')) return 'Hard';
    if (content.includes('<h3>Medium</h3>')) return 'Medium';
    if (content.includes('<h3>Easy</h3>')) return 'Easy';
  }
  return 'Unknown';
}

// Get all problem folders
function getProblemFolders() {
  const dirs = fs.readdirSync('.').filter(f => {
    return fs.statSync(f).isDirectory() && /^\d{4}/.test(f);
  });
  return dirs;
}

// Parse platform and count from folder name
function parseProblem(folderName) {
  const match = folderName.match(/^(\d+)-(.+)/);
  if (!match) return null;
  
  const [, id, name] = match;
  const problemNum = parseInt(id);
  
  let platform = 'LeetCode';
  if (folderName.includes('-GFG')) platform = 'GeeksforGeeks';
  if (folderName.includes('-HackerRank')) platform = 'HackerRank';
  
  return { id, name, platform, folderName, problemNum };
}

// Main update function
function updateReadme() {
  const problems = getProblemFolders()
    .map(parseProblem)
    .filter(p => p !== null)
    .map(p => ({
      ...p,
      difficulty: extractDifficultyFromReadme(p.folderName),
      url: `https://github.com/Syed-Aadil-Sameer-M/Leetcode-GFG-HackerRank-JAVA_Implementation/tree/main/${p.folderName}`
    }));

  // Count statistics
  const stats = {
    total: problems.length,
    easy: problems.filter(p => p.difficulty === 'Easy').length,
    medium: problems.filter(p => p.difficulty === 'Medium').length,
    hard: problems.filter(p => p.difficulty === 'Hard').length,
    leetcode: problems.filter(p => p.platform === 'LeetCode').length,
    gfg: problems.filter(p => p.platform === 'GeeksforGeeks').length,
    hackerrank: problems.filter(p => p.platform === 'HackerRank').length,
  };

  stats.easyPercent = Math.round((stats.easy / stats.total) * 100);
  stats.mediumPercent = Math.round((stats.medium / stats.total) * 100);
  stats.hardPercent = Math.round((stats.hard / stats.total) * 100);

  // Generate progress bars
  const easyBar = '█'.repeat(stats.easyPercent / 5) + '░'.repeat(20 - Math.ceil(stats.easyPercent / 5));
  const mediumBar = '█'.repeat(stats.mediumPercent / 5) + '░'.repeat(20 - Math.ceil(stats.mediumPercent / 5));
  const hardBar = '█'.repeat(stats.hardPercent / 5) + '░'.repeat(20 - Math.ceil(stats.hardPercent / 5));

  // Read current README
  let readme = fs.readFileSync('README.md', 'utf8');

  // Update statistics section
  const statsRegex = /╔════════════════════════════════════════════════════════════╗\n║                    SOLVED PROBLEMS                         ║\n║                                                            ║\n║                   📈 \d+\+ PROBLEMS                          ║\n║                                                            ║\n║   ✅ Easy      [█░]*\(\d+\) ║\n║   🟡 Medium    [█░]*\(\d+\) ║\n║   🔴 Hard      [█░]*\(\d+\) ║/;

  const newStats = `╔════════════════════════════════════════════════════════════╗
║                    SOLVED PROBLEMS                         ║
║                                                            ║
║                   📈 ${stats.total}+ PROBLEMS                          ║
║                                                            ║
║   ✅ Easy      ${easyBar}(${stats.easy}) ║
║   🟡 Medium    ${mediumBar}(${stats.medium}) ║
║   🔴 Hard      ${hardBar}(${stats.hard}) ║`;

  readme = readme.replace(statsRegex, newStats);

  // Update platform breakdown table
  const tableRegex = /\| Platform \| Count \| Easy \| Medium \| Hard \|\n\|----------|-------|------|--------|------|\n\|[^|]+\|[^|]+\|[^|]+\|[^|]+\|[^|]+\|\n\|[^|]+\|[^|]+\|[^|]+\|[^|]+\|[^|]+\|\n\|[^|]+\|[^|]+\|[^|]+\|[^|]+\|[^|]+\|/;

  const leetcodeStats = {
    total: problems.filter(p => p.platform === 'LeetCode').length,
    easy: problems.filter(p => p.platform === 'LeetCode' && p.difficulty === 'Easy').length,
    medium: problems.filter(p => p.platform === 'LeetCode' && p.difficulty === 'Medium').length,
    hard: problems.filter(p => p.platform === 'LeetCode' && p.difficulty === 'Hard').length,
  };

  const gfgStats = {
    total: problems.filter(p => p.platform === 'GeeksforGeeks').length,
    easy: problems.filter(p => p.platform === 'GeeksforGeeks' && p.difficulty === 'Easy').length,
    medium: problems.filter(p => p.platform === 'GeeksforGeeks' && p.difficulty === 'Medium').length,
    hard: problems.filter(p => p.platform === 'GeeksforGeeks' && p.difficulty === 'Hard').length,
  };

  const hackerrankStats = {
    total: problems.filter(p => p.platform === 'HackerRank').length,
    easy: problems.filter(p => p.platform === 'HackerRank' && p.difficulty === 'Easy').length,
    medium: problems.filter(p => p.platform === 'HackerRank' && p.difficulty === 'Medium').length,
    hard: problems.filter(p => p.platform === 'HackerRank' && p.difficulty === 'Hard').length,
  };

  const newTable = `| Platform | Count | Easy | Medium | Hard |
|----------|-------|------|--------|------|
| 💻 **LeetCode** | ${leetcodeStats.total} | ${leetcodeStats.easy} | ${leetcodeStats.medium} | ${leetcodeStats.hard} |
| 🎓 **GeeksforGeeks** | ${gfgStats.total} | ${gfgStats.easy} | ${gfgStats.medium} | ${gfgStats.hard} |
| ⚡ **HackerRank** | ${hackerrankStats.total} | ${hackerrankStats.easy} | ${hackerrankStats.medium} | ${hackerrankStats.hard} |`;

  readme = readme.replace(tableRegex, newTable);

  // Update difficulty distribution
  const diffRegex = /DIFFICULTY DISTRIBUTION\n═══════════════════════════════════════════\n\n🟢 Easy \(\d+%\)\n[█░]+\s+\d+\n\n🟡 Medium \(\d+%\)\n[█░]+\s+\d+\n\n🔴 Hard \(\d+%\)\n[█░]+\s+\d+/;

  const newDiff = `DIFFICULTY DISTRIBUTION
═══════════════════════════════════════════

🟢 Easy (${stats.easyPercent}%)
${easyBar} ${stats.easy}

🟡 Medium (${stats.mediumPercent}%)
${mediumBar} ${stats.medium}

🔴 Hard (${stats.hardPercent}%)
${hardBar} ${stats.hard}`;

  readme = readme.replace(diffRegex, newDiff);

  // Update key features
  const featuresRegex = /- ✨ \*\*\d+\+ Problems Solved\*\*:/;
  readme = readme.replace(featuresRegex, `- ✨ **${stats.total}+ Problems Solved**:`);

  const multiplatformRegex = /- 🏆 \*\*Multi-platform\*\*: Solutions from LeetCode \(\d+\), GeeksforGeeks \(\d+\), and HackerRank \(\d+\)/;
  readme = readme.replace(multiplatformRegex, `- 🏆 **Multi-platform**: Solutions from LeetCode (${stats.leetcode}), GeeksforGeeks (${stats.gfg}), and HackerRank (${stats.hackerrank})`);

  // Write updated README
  fs.writeFileSync('README.md', readme);
  console.log('✅ README updated successfully!');
  console.log(`📊 Total Problems: ${stats.total}`);
  console.log(`   Easy: ${stats.easy} | Medium: ${stats.medium} | Hard: ${stats.hard}`);
}

// Run the update
updateReadme();
