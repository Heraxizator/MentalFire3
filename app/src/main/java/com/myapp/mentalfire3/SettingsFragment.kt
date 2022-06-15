package com.myapp.mentalfire3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.*
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData
import com.yandex.mobile.ads.rewarded.Reward
import com.yandex.mobile.ads.rewarded.RewardedAd
import com.yandex.mobile.ads.rewarded.RewardedAdEventListener

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        val theme = findPreference<ListPreference>("theme")
        val plus = findPreference<Preference>("plus")
        val block = findPreference<Preference>("block")
        val version = findPreference<Preference>("version")
        val delete = findPreference<Preference>("delete")
        val notification = findPreference<SwitchPreference>("notification")
        val sp = SharedPreferences(requireContext())


        version?.summary = BuildConfig.VERSION_CODE.toString()

        theme?.onPreferenceChangeListener =
            Preference.OnPreferenceChangeListener { _, newValue ->


                if (!sp.getAdBlock()) {
                    val mRewardedAd = RewardedAd(requireContext())
                    mRewardedAd.setAdUnitId("R-M-1708838-12")

                    val request = AdRequest.Builder().build()

                    mRewardedAd.setRewardedAdEventListener(object : RewardedAdEventListener {
                        override fun onAdLoaded() {
                            mRewardedAd.show()
                        }

                        override fun onAdFailedToLoad(p0: AdRequestError) {

                        }

                        override fun onAdShown() {
                            sp.setTheme(newValue as String)

                            when (newValue) {
                                resources.getString(R.string.system) -> {
                                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                                }

                                resources.getString(R.string.dark) -> {
                                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                                }

                                resources.getString(R.string.light) -> {
                                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                                }
                            }

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

                //ad.loadRewardedAd("R-M-1708838-12")
                true
            }

        plus?.onPreferenceClickListener = Preference.OnPreferenceClickListener {

            if (!sp.getAdBlock()) {
                val mRewardedAd = RewardedAd(requireContext())
                mRewardedAd.setAdUnitId("R-M-1708838-13")

                val request = AdRequest.Builder().build()

                mRewardedAd.setRewardedAdEventListener(object : RewardedAdEventListener {
                    override fun onAdLoaded() {
                        mRewardedAd.show()
                    }

                    override fun onAdFailedToLoad(p0: AdRequestError) {

                    }

                    override fun onAdShown() {
                        sp.setAdPlus(true)
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

            //ad.loadRewardedAd("R-M-1708838-13")

            true
        }

        block?.onPreferenceClickListener = Preference.OnPreferenceClickListener {


            if (!sp.getAdBlock()) {
                val mRewardedAd = RewardedAd(requireContext())
                mRewardedAd.setAdUnitId("R-M-1708838-14")

                val request = AdRequest.Builder().build()

                mRewardedAd.setRewardedAdEventListener(object : RewardedAdEventListener {
                    override fun onAdLoaded() {
                        mRewardedAd.show()
                    }

                    override fun onAdFailedToLoad(p0: AdRequestError) {

                    }

                    override fun onAdShown() {
                        sp.setAdBlock(true)
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

            //ad.loadRewardedAd("R-M-1708838-14")

            true
        }

        delete?.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            sp.deleteData()
            Toast.makeText(requireContext(), resources.getString(R.string.deleted), Toast.LENGTH_SHORT).show()
            true
        }

        notification?.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { preference, newValue ->
            sp.setNotification(newValue as Boolean)

            true
        }



    }
}