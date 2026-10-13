package ru.korndev.bug

open class BugService {
    private var bugList = mutableListOf<BugReport>()
    private var idCounter = 1

    fun createBug(title: String, description: String, priority: BugPriority) {
        val bug = BugReport(
            id = idCounter,
            title = title,
            description = description,
            status = BugStatus.NEW,
            priority = priority
        )
        idCounter++
        bugList.add(bug)
    }

    fun changeStatus(id: Int, newStatus: BugStatus) {
        if (newStatus == BugStatus.CLOSED && bugList[id].status != BugStatus.UNDER_TESTING) {
            error("Невозмоожно перевести в статус закрыто без проверки")
        }

        val index = bugList.indexOfFirst { it.id == id }
        if (index != -1) {
        bugList[index] = bugList[id].copy(status = newStatus)
        }
    }

    fun viewBugList(priority: BugPriority? = null): MutableList<BugReport> {

        if (priority == null) {
            return bugList
        }

        val returnedList = mutableListOf<BugReport>()

        returnedList.addAll(bugList.filter { it.priority == priority })

        return returnedList
    }
}