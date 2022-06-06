package com.bongonets.onboardingapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter(private val context: Context): PagerAdapter() {

    var layoutInflater: LayoutInflater? = null

    //arrays of images, titles, and descriptions
    private val imgArray = arrayOf(
        R.drawable.santa,
        R.drawable.candycane,
        R.drawable.reindeer
    )

    private val titleArray = arrayOf(
        "Dear Santa",
        "Ho Ho Ho",
        "Merry Christmas"
    )

    private val descriptionArray = arrayOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
    )

    override fun getCount(): Int {
        return titleArray.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = layoutInflater!!.inflate(R.layout.slider, container, false)
        val img = view.findViewById<ImageView>(R.id.image)
        val title = view.findViewById<TextView>(R.id.title)
        val description = view.findViewById<TextView>(R.id.description)

        img.setImageResource(imgArray[position])
        title.text = titleArray[position]
        description.text = descriptionArray[position]

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}