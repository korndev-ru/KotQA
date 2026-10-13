package ru.korndev

import ru.korndev.bug.BugPriority
import ru.korndev.bug.BugReport
import ru.korndev.bug.BugService
import ru.korndev.bug.BugStatus
import ru.korndev.utils.setupConsoleEncoding

fun main() {
    setupConsoleEncoding()
    val bugService = BugService()

    while (true) {  val line = readlnOrNull() ?: break
        if (line.isBlank()) continue


    }
    var bug1 = bugService.createBug("тест 1", "Описание 1", BugPriority.LOW)
    var bug2 = bugService.createBug("тест 2", "Описание 2", BugPriority.HIGH)
    var bug3 = bugService.createBug("тест 3", "Описание 3", BugPriority.MEDIUM)
    var bug4 = bugService.createBug("тест 4", "Описание 4", BugPriority.HIGH)
    bug1 = bugService.changeStatus(1, BugStatus.UNDER_TESTING)

    (bugService.viewBugList(BugPriority.HIGH).forEach (::println))


}