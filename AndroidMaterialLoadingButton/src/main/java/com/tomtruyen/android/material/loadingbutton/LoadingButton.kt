package com.tomtruyen.android.material.loadingbutton

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.progressindicator.CircularProgressIndicator

const val ICON_GRAVITY_START = "0x1"
const val ICON_GRAVITY_TEXT_START = "0x2"
const val ICON_GRAVITY_END = "0x3"
const val ICON_GRAVITY_TEXT_END = "0x4"
const val ICON_GRAVITY_TOP = "0x5"
const val ICON_GRAVITY_TEXT_TOP = "0x6"

@SuppressLint("CustomViewStyleable")
class LoadingButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
): RelativeLayout(context, attrs, defStyleAttr) {
    private var button: MaterialButton
    private var progressIndicator: CircularProgressIndicator

    private var buttonText: String? = null
    private var buttonIcon: Drawable? = null
    var isLoading = false
        private set

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.material_loading_button, this, true)

        button = view.findViewById(R.id.material_loading_button_button)
        progressIndicator = view.findViewById(R.id.material_loading_button_progress_indicator)

        attrs?.let {
            val styledAttributes = context.obtainStyledAttributes(it,
                R.styleable.Button, 0, 0)

            // Required to remove default padding created by the Layout...
            super.setPadding(0, 0, 0, 0)

            val text = styledAttributes.getString(R.styleable.Button_LoadingButton_text) ?: ""
            val textColor = styledAttributes.getColor(R.styleable.Button_LoadingButton_textColor, Color.WHITE)
            val textSize = styledAttributes.getDimension(R.styleable.Button_LoadingButton_textSize, 14f)
            val icon = styledAttributes.getDrawable(R.styleable.Button_LoadingButton_icon)
            val iconGravity = styledAttributes.getString(R.styleable.Button_LoadingButton_iconGravity) ?: "start"
            val iconSize = styledAttributes.getDimensionPixelSize(R.styleable.Button_LoadingButton_iconSize, TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 24f, resources.displayMetrics).toInt()
            )
            val iconPadding = styledAttributes.getDimensionPixelSize(R.styleable.Button_LoadingButton_iconPadding, TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 8f, resources.displayMetrics).toInt()
            )
            val indicatorIndeterminate = styledAttributes.getBoolean(R.styleable.Button_LoadingButton_indeterminate, true)
            val indicatorColor = styledAttributes.getColor(R.styleable.Button_LoadingButton_indicatorColor, Color.WHITE)
            val indicatorSize = styledAttributes.getDimensionPixelSize(R.styleable.Button_LoadingButton_indicatorSize, TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 32f, resources.displayMetrics).toInt()
            )
            val indicatorThickness = styledAttributes.getDimensionPixelSize(R.styleable.Button_LoadingButton_indicatorThickness, TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 2f, resources.displayMetrics).toInt()
            )

            setText(text)
            setTextColor(textColor)
            setTextSize(textSize)
            setIcon(icon)
            setIconGravity(iconGravity)
            setIconSize(iconSize)
            setIconPadding(iconPadding)
            setIndicatorIndeterminate(indicatorIndeterminate)
            setIndicatorColor(indicatorColor)
            setIndicatorSize(indicatorSize)
            setIndicatorThickness(indicatorThickness)

            button.setOnClickListener { this@LoadingButton.callOnClick() }

            styledAttributes.recycle()
        }
    }

    fun startLoading() {
        isLoading = true
        progressIndicator.visibility = View.VISIBLE
        button.text = null
        button.icon = null
        button.isEnabled = false
    }

    fun stopLoading() {
        isLoading = false
        progressIndicator.visibility = View.GONE
        button.text = buttonText
        button.icon = buttonIcon
        button.isEnabled = true
    }

    private fun setText(text: String) {
        button.text = text
        buttonText = text
    }

    private fun setTextColor(color: Int) {
        button.setTextColor(color)
    }

    private fun setTextSize(size: Float) {
        button.textSize = size
    }

    private fun setIcon(icon: Drawable?) {
        button.icon = icon
        buttonIcon = icon
    }

    private fun setIconGravity(gravity: String) {
        when (gravity) {
            ICON_GRAVITY_START -> button.iconGravity = MaterialButton.ICON_GRAVITY_START
            ICON_GRAVITY_END -> button.iconGravity = MaterialButton.ICON_GRAVITY_END
            ICON_GRAVITY_TOP -> button.iconGravity = MaterialButton.ICON_GRAVITY_TOP
            ICON_GRAVITY_TEXT_START -> button.iconGravity = MaterialButton.ICON_GRAVITY_TEXT_START
            ICON_GRAVITY_TEXT_END -> button.iconGravity = MaterialButton.ICON_GRAVITY_TEXT_END
            ICON_GRAVITY_TEXT_TOP -> button.iconGravity = MaterialButton.ICON_GRAVITY_TEXT_TOP
            else -> button.iconGravity = MaterialButton.ICON_GRAVITY_START
        }
    }

    private fun setIconSize(size: Int) {
        button.iconSize = size
    }

    private fun setIconPadding(padding: Int) {
        button.iconPadding = padding
    }

    private fun setIndicatorIndeterminate(indeterminate: Boolean) {
        progressIndicator.isIndeterminate = indeterminate
    }

    private fun setIndicatorColor(color: Int) {
        progressIndicator.setIndicatorColor(color)
    }

    private fun setIndicatorSize(size: Int) {
        progressIndicator.indicatorSize = size
    }

    private fun setIndicatorThickness(thickness: Int) {
        progressIndicator.trackThickness = thickness
    }

    fun onClick(listener: (LoadingButton) -> Unit) {
        button.setOnClickListener { listener(this) }
    }
}