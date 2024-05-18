package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {

  @Query("SELECT * FROM bus_schedule WHERE id = :id")
  fun getSchedule(id: Int): Flow<BusSchedule>

  @Query("SELECT * FROM bus_schedule WHERE stop_name = :stopName")
  fun getBusScheduleByStopName(stopName: String): Flow<List<BusSchedule>>

  @Query("SELECT * FROM bus_schedule ORDER BY arrival_time ASC")
  fun getAllSchedules(): Flow<List<BusSchedule>>
}