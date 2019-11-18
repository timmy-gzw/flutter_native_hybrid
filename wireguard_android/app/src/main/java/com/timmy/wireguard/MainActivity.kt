package com.timmy.wireguard

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import io.flutter.facade.Flutter
import io.flutter.plugin.common.PluginRegistry

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // addFlutterFragment()
        addFlutter()
    }



    private fun addFlutter() {
        val flutterView = Flutter.createView(this, lifecycle, "route1")
        val layout = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        addContentView(flutterView, layout)
        //  GeneratedPluginRegistrant.registerWith(flutterView.pluginRegistry)
        //  PermissionHandlerPlugin.registerWith(flutterView.pluginRegistry)
        registerCustomPlugin(flutterView.pluginRegistry)
    }

    private fun addFlutterFragment() {
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.flamelayou, FlutterBaseFragment.newInstance("route1"))
        beginTransaction.commit()
    }

    private fun registerCustomPlugin(registrar: PluginRegistry) {
        FlutterPluginJumpToAct.registerWith(registrar.registrarFor(FlutterPluginJumpToAct.CHANNEL))
    }
}
