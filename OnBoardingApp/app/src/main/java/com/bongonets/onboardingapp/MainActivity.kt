package com.bongonets.onboardingapp

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_DearSanta)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        val relativeLayout: RelativeLayout = findViewById(R.id.layout1)
        val btnContinue = findViewById<Button>(R.id.btn)
        val animationDrawable = relativeLayout.background as AnimationDrawable
        addAnimation(animationDrawable)

        viewPager = findViewById(R.id.view_pager)
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter
        dotsIndicator.setViewPager(viewPager)

        btnContinue.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixel: Int
            ) {

            }
            override fun onPageSelected(position: Int){
                if (position == 0){
                    relativeLayout.setBackgroundResource(R.drawable.gradient_bg_green)
                    val animationDrawable = relativeLayout.background as AnimationDrawable
                    addAnimation(animationDrawable)
                    btnContinue.visibility = View.GONE
                }

                if (position == 1){
                    relativeLayout.setBackgroundResource(R.drawable.gradient_bg_blue)
                    val animationDrawable = relativeLayout.background as AnimationDrawable
                    addAnimation(animationDrawable)
                    btnContinue.visibility = View.GONE
                }

                if (position == 2){
                    relativeLayout.setBackgroundResource(R.drawable.gradient_bg_red)
                    val animationDrawable = relativeLayout.background as AnimationDrawable
                    addAnimation(animationDrawable)
                    btnContinue.visibility = View.VISIBLE
                }
            }

            override fun onPageScrollStateChanged(state: Int){

            }
        })
    }

    fun addAnimation(animationDrawable: AnimationDrawable){
        animationDrawable.setEnterFadeDuration(3500)
        animationDrawable.setExitFadeDuration(1000)
        animationDrawable.start()
    }
}