package com.example.samplelogin.data


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginResponse(
    @SerializedName("CanCloseWorkOrder")
    val canCloseWorkOrder: Int,
    @SerializedName("CanCreateInspections")
    val canCreateInspections: Int,
    @SerializedName("CanScanAssetCode")
    val canScanAssetCode: Boolean,
    @SerializedName("CanViewInspections")
    val canViewInspections: Int,
    @SerializedName("CanViewPortfolioData")
    val canViewPortfolioData: Boolean,
    @SerializedName("Code")
    val code: Int,
    @SerializedName("CompanyID")
    val companyID: Int,
    @SerializedName("CompanyShortName")
    val companyShortName: String,
    @SerializedName("CompanyUsesAssetCode")
    val companyUsesAssetCode: Boolean,
    @SerializedName("CompanyUsesGeodispatch")
    val companyUsesGeodispatch: Boolean,
    @SerializedName("Domain")
    val domain: String,
    @SerializedName("EmployeeID")
    val employeeID: Int,
    @SerializedName("HasVendorCOI")
    val hasVendorCOI: Boolean,
    @SerializedName("IsAvailablePI")
    val isAvailablePI: Boolean,
    @SerializedName("IsAvailablePM")
    val isAvailablePM: Boolean,
    @SerializedName("IsRequestTypeRequired")
    val isRequestTypeRequired: Boolean,
    @SerializedName("NotificationPermission")
    val notificationPermission: Int,
    @SerializedName("PmWorkOrderPermission")
    val pmWorkOrderPermission: Int,
    @SerializedName("Pools")
    val pools: List<Int>,
    @SerializedName("RealName")
    val realName: String,
    @SerializedName("Role")
    val role: Int,
    @SerializedName("SendMessages")
    val sendMessages: Int,
    @SerializedName("ShowEmergencySection")
    val showEmergencySection: Boolean,
    @SerializedName("ShowLeases")
    val showLeases: Int,
    @SerializedName("ShowPI")
    val showPI: Boolean,
    @SerializedName("ShowPM")
    val showPM: Boolean,
    @SerializedName("ShowServiceDollarValues")
    val showServiceDollarValues: Int,
    @SerializedName("ShowServices")
    val showServices: Int,
    @SerializedName("ShowTR")
    val showTR: Boolean,
    @SerializedName("ShowTenantContactSearch")
    val showTenantContactSearch: Boolean,
    @SerializedName("ShowTrWorkOrderSearch")
    val showTrWorkOrderSearch: Boolean,
    @SerializedName("ShowVendorCoiSection")
    val showVendorCoiSection: Boolean,
    @SerializedName("ShowVendorSearch")
    val showVendorSearch: Boolean,
    @SerializedName("TrWorkOrderPermission")
    val trWorkOrderPermission: Int,
    @SerializedName("UserName")
    val userName: String,
    @SerializedName("UsesAdmin")
    val usesAdmin: Boolean,
    @SerializedName("UsesBillingApproval")
    val usesBillingApproval: Boolean
) : Serializable