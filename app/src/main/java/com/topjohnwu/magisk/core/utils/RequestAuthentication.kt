package com.topjohnwu.magisk.core.utils

import android.app.Activity
import android.app.KeyguardManager
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.result.contract.ActivityResultContract

class RequestAuthentication: ActivityResultContract<Unit, Boolean>() {

    override fun createIntent(context: Context, input: Unit) =
        context.getSystemService(KeyguardManager::class.java)
            .createConfirmDeviceCredentialIntent(null, null)

    override fun parseResult(resultCode: Int, intent: Intent?) =
        Log.d("aviraxp", "result $resultCode")
        resultCode == Activity.RESULT_OK
}
