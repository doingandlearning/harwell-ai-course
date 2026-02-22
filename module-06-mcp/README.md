# Module 6: Model Context Protocol (MCP) Principles

## Learning objectives

- Explain the “silo” problem: AI tools unable to access local files, repos, or databases directly.
- Describe the Model Context Protocol (MCP) as a standard for supplying context to AI.
- Outline how MCP works: standardised context servers connecting AI to git repos, databases, or local files.
- Discuss implications: how tools like Claude Desktop or IDEs can use MCP to “read” project structure without manually uploading code to the cloud.

## Suggested talking points

- Frame explicitly: this section is **orientation**, not adoption or rollout guidance.
- The problem: AI in the browser or in an app often can’t see your repo, DB, or files unless you paste.
- The solution: a protocol so that “context servers” expose project structure, files, or data in a standard way.
- How it works: servers (e.g. “filesystem,” “git,” “database”); clients (Claude Desktop, IDEs) request context through the protocol.
- Implications: safer, structured access to context; less copy-paste; still early—expect evolution.
- When to consider MCP: when you need AI to reason over many files or live data in a controlled way.

## Suggested demos

- **Diagram:** One slide showing “without MCP” (paste only) vs. “with MCP” (IDE or client asks context server for repo/files).
- **Optional:** If available, short demo of Claude Desktop (or similar) with an MCP server (e.g. filesystem) so the model can “see” a small project.
- Keep demos conceptual or very light; avoid implying production rollout.

## Suggested exercises

- **Reflection:** Write one sentence: “MCP would help my team if…”
- **Scenario:** Imagine your IDE could safely expose “only this module” to an AI via MCP; list 2 tasks that would become easier.
- **Discussion:** In pairs, when would you want the AI to have direct access to repo vs. paste-only?

## Suggested running time

30–45 minutes (orientation only)
