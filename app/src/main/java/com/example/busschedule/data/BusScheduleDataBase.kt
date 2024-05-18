package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BusSchedule::class], version = 1)
abstract class BusScheduleDataBase : RoomDatabase() {

  abstract fun busScheduleDao(): BusScheduleDao

  companion object {
    @Volatile
    private var Instance: BusScheduleDataBase? = null

    fun getDatabase(context: Context): BusScheduleDataBase {
      return Instance ?: synchronized(this) {
        Room.databaseBuilder(
          context,
          BusScheduleDataBase::class.java,
          "bus_schedule_database"
        )
          .createFromAsset("database/bus_schedule.db")
          .fallbackToDestructiveMigration()
          .build()
          .also {
            Instance = it
          }
      }
    }
  }
}