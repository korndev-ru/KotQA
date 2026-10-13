package ru.korndev.bug

data class BugReport(
    val id: Int,
    val title: String,
    val description: String,
    val status: BugStatus,
    val priority: BugPriority
)
