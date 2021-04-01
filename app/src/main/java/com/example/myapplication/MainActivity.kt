package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    var mSliderAdapter: ImageSliderAdapter? = null
    private var viewpager: ViewPager2? = null
    var vLeft: View? = null
    var vCenter: View? = null
    var vRight: View? = null
    private var cCenter: Float = 0f
    private var cRight: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager = findViewById(R.id.viewpager)
        vLeft = findViewById(R.id.vLeft)
        vCenter = findViewById(R.id.vCenter)
        vRight = findViewById(R.id.vRight)

        mSliderAdapter = ImageSliderAdapter(this)
        viewpager?.adapter = mSliderAdapter
        viewpager?.currentItem = 0


        val onPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                Log.e("cse_offset", "position: $position")
                Log.e("cse_offset", "positionOffset: $positionOffset")
                Log.e("cse_offset", "positionOffsetPixels: $positionOffsetPixels")

                vCenter?.let {
                    cCenter = it.x + (it.width / 2)
                    Log.e("cse_offset", "c_center: $cCenter")
                }
                vRight?.let {
                    cRight = it.x + (it.width / 2)
                    Log.e("cse_offset", "c_right: $cRight")
                }
                vRight?.let {
                    if (position < (mSliderAdapter?.itemCount ?: 0)) {
                        it.x -= (cRight - cCenter) / (positionOffsetPixels + 0.001f) * positionOffset * 6
                    }
                }
            }
        }
        viewpager?.registerOnPageChangeCallback(onPageChangeCallback)
    }
}