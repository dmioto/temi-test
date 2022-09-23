package com.miotoda.mystore.core

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.SearchView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import com.miotoda.mystore.R
import com.miotoda.mystore.databinding.ComponentToolbarBinding

@BindingMethods(
        BindingMethod(
                type = MyStoreToolbar::class,
                attribute = "setRightButtonOnClickListener",
                method = "setRightOnClickListener"
        )
)

class MyStoreToolbar @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding = ComponentToolbarBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        attrs?.let { setupLayout(it, defStyleAttr) }
    }

    private fun setupLayout(attrs: AttributeSet, defStyleAttr: Int) {
        context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.MyStoreToolbar,
                defStyleAttr,
                0
        ).run {
//            setRightButtonIconColor(getRightButtonIconColor())
//            setRightButtonIcon(getRightButtonIcon())
            setRightButtonContentDescription(getRightButtonDescription())
            recycle()
        }

        binding.btnSearch.setBackgroundColor(Color.parseColor("#FFFFFF"))
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun TypedArray.getRightButtonIconColor() = getColor(
            R.styleable.MyStoreToolbar_rightButtonIconColor,
            resources.getColor(R.color.white, null)
    )

    private fun TypedArray.getRightButtonIcon() = getResourceId(
            R.styleable.MyStoreToolbar_rightButtonIcon,
            R.drawable.ic_baseline_search_24
    )

    private fun TypedArray.getRightButtonDescription() = getText(
            R.styleable.MyStoreToolbar_rightButtonDescription
    )

    fun setRightButtonOnClickListener(listener: OnClickListener) {
        binding.btnSearch.setOnClickListener(listener)
    }

    fun setSearchQuery() {
        binding.btnSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
//                if (programmingLanguagesList.contains(query)) {
//                    listAdapter.filter.filter(query)
//                } else {
//                    Toast.makeText(context, "No Language found..", Toast.LENGTH_LONG).show()
//                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
//
//                listAdapter.filter.filter(newText)
                return false
            }
        })
    }

//    fun setRightButtonIconColor(@ColorInt color: Int) {
//        binding.btnSearch.imageTintList = ColorStateList.valueOf(color)
//    }
//
//    fun setRightButtonIcon(@DrawableRes drawId: Int) {
//        binding.btnSearch.setImageResource(drawId)
//    }

    fun setRightButtonContentDescription(description: CharSequence?) {
        binding.btnSearch.contentDescription = description
    }
}