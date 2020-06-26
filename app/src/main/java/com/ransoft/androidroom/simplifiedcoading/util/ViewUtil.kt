package com.ransoft.androidroom.simplifiedcoading.util

import android.content.Context
import android.widget.Toast

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}