package com.example.gadgetgalaxy.common

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String?) {
    Glide.with(this.context).load(url).into(this)
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.GONE
}

fun String.isValidEmail(email: String): Boolean {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
    if (!email.isNullOrEmpty() && email.matches(emailRegex.toRegex())) {
        return true
    }
    return false
}

fun String.isValidPassword(password: String): Boolean {
    if (!password.isNullOrEmpty() && password.length >= 6) {
        return true
    }
    return false
}
