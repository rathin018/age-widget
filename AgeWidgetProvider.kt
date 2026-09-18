package com.rathin.agewidget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import java.time.LocalDate
import java.time.Period

class AgeWidgetProvider : AppWidgetProvider() {

    companion object {
        // ---- Your actual birth date ----
        private val BIRTH_DATE: LocalDate = LocalDate.of(2002, 10, 9)

        // If you ever want to switch to the certificate date instead, comment
        // the line above and uncomment this one:
        // private val BIRTH_DATE: LocalDate = LocalDate.of(2005, 4, 14)

        fun buildAgeText(): String {
            val today = LocalDate.now()
            val period: Period = Period.between(BIRTH_DATE, today)
            return "${period.years}y ${period.months}m ${period.days}d"
        }
    }

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (widgetId in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.age_widget_layout)
            views.setTextViewText(R.id.age_text, buildAgeText())
            appWidgetManager.updateAppWidget(widgetId, views)
        }
    }
}
