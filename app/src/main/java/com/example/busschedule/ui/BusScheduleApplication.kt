package com.example.busschedule.ui

import android.app.Application
import com.example.busschedule.data.BusScheduleDataBase

class BusScheduleApplication : Application() {
  val database: BusScheduleDataBase by lazy { BusScheduleDataBase.getDatabase(this) }
}
