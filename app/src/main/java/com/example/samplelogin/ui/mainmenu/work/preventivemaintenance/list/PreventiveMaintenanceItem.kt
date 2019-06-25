package com.example.samplelogin.ui.mainmenu.work.preventivemaintenance.list

data class PreventiveMaintenanceItem(
    var description: String,
    var propertyName: String,
    var buildingName: String,
    var employeeName: String,
    var requestId: Int
)