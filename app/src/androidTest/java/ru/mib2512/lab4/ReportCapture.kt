package ru.mib2512.lab4
import android.graphics.Bitmap
import androidx.test.platform.app.InstrumentationRegistry
import java.io.File
object ReportCapture {
    fun save(name: String) {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        instrumentation.waitForIdleSync()
        Thread.sleep(500)
        val screenshot = instrumentation.uiAutomation.takeScreenshot() ?: error("Screenshot unavailable")
        val directory = File(instrumentation.targetContext.filesDir, "report_screenshots").apply { mkdirs() }
        File(directory, "$name.png").outputStream().use { screenshot.compress(Bitmap.CompressFormat.PNG, 100, it) }
        screenshot.recycle()
    }
}
