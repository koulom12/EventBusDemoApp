package com.riook.eventbusdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.riook.eventbusdemo.Events.CartEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity() {
    var cartEventList: MutableList<CartEvent> = ArrayList()
    var cartTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cartTextView = findViewById(R.id.cartTextView)
    }

    fun open(view: View) {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    @Subscribe
    open fun onCartItemAdd(cartEvent: CartEvent?) {
        if (cartEvent != null) {
            cartEventList.add(cartEvent)
        }
        val cartTotalItems = "Cart Items: " + cartEventList.size
        cartTextView?.text = cartTotalItems
        Toast.makeText(this, "Item added to cart.", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        if (!EventBus.getDefault().isRegistered(this)) EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

}