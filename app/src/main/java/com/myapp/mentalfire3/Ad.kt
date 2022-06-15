package com.myapp.mentalfire3

import android.content.Context
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData
import com.yandex.mobile.ads.interstitial.InterstitialAd
import com.yandex.mobile.ads.interstitial.InterstitialAdEventListener
import com.yandex.mobile.ads.rewarded.Reward
import com.yandex.mobile.ads.rewarded.RewardedAd
import com.yandex.mobile.ads.rewarded.RewardedAdEventListener

class Ad (val context: Context){
    val sp = SharedPreferences(context)
    fun loadFullScreenAd(id : String) {
        if (!sp.getAdBlock()) {
            val mInterstitialAd = InterstitialAd(context)
            mInterstitialAd.setAdUnitId(id)
            val request = AdRequest.Builder().build()

            mInterstitialAd.setInterstitialAdEventListener(object : InterstitialAdEventListener {
                override fun onAdLoaded() {
                    mInterstitialAd.show()
                }

                override fun onAdFailedToLoad(p0: AdRequestError) {

                }

                override fun onAdShown() {

                }

                override fun onAdDismissed() {

                }

                override fun onAdClicked() {

                }

                override fun onLeftApplication() {

                }

                override fun onReturnedToApplication() {
                }

                override fun onImpression(p0: ImpressionData?) {

                }

            })

            try {
                mInterstitialAd.loadAd(request)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


    }

    fun loadRewardedAd(id : String) {

        if (!sp.getAdBlock()) {
            val mRewardedAd = RewardedAd(context)
            mRewardedAd.setAdUnitId(id)

            val request = AdRequest.Builder().build()

            mRewardedAd.setRewardedAdEventListener(object : RewardedAdEventListener {
                override fun onAdLoaded() {
                    mRewardedAd.show()
                }

                override fun onAdFailedToLoad(p0: AdRequestError) {

                }

                override fun onAdShown() {

                }

                override fun onAdDismissed() {

                }

                override fun onRewarded(p0: Reward) {

                }

                override fun onAdClicked() {

                }

                override fun onLeftApplication() {

                }

                override fun onReturnedToApplication() {

                }

                override fun onImpression(p0: ImpressionData?) {

                }

            })

            try {
                mRewardedAd.loadAd(request)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


    }

    fun randomMode(probability : Int) : Boolean {
        val b = (1..probability)
        return b.random() == 1
    }
}
