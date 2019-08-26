package com.rmakiyama.edittextsample.ui

import android.content.Context
import android.text.Editable
import android.text.Spannable
import android.text.style.BackgroundColorSpan
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.rmakiyama.edittextsample.R

class FeedbackLikeTwitterWatcher(
    context: Context,
    private val maxLength: Int,
    @ColorRes feedbackColorRes: Int = R.color.colorAccent,
    private val afterTextChangedListener: (isOverMaxLength: Boolean) -> Unit
) : SimpleTextWatcher {

    private val feedbackColor = ContextCompat.getColor(context, feedbackColorRes)

    override fun afterTextChanged(editable: Editable) {
        if (editable.length > maxLength) {
            val span = BackgroundColorSpan(feedbackColor)
            editable.setSpan(
                span,
                maxLength,
                editable.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        afterTextChangedListener(editable.length > maxLength)
    }
}
