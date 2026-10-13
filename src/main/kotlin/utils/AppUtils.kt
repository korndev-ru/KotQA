package ru.korndev.utils

import java.io.FileDescriptor
import java.io.FileOutputStream
import java.io.PrintStream


fun setupConsoleEncoding() = try {
    System.setOut(PrintStream(FileOutputStream(FileDescriptor.out), true, "UTF-8"))
} catch (e: Exception) {
    System.err.println("Не удалось принудительно установить UTF-8: ${e.message}")
}

