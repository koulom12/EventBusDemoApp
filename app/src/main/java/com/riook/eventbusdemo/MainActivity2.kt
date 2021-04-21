package com.riook.eventbusdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.riook.eventbusdemo.Events.CartEvent
import org.greenrobot.eventbus.EventBus

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun addItemToCart(view: View) {
        EventBus.getDefault().post(CartEvent("New cart item"))
    }
}