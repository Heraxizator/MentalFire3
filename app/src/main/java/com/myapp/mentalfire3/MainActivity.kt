package com.myapp.mentalfire3

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.myapp.mentalfire3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    var nid = 1
    var cid = "Channel"
    var title = "Hello! It's the Fast Relaxation"
    var title2 = "Fast Relaxation is calling!"
    var title3 = "Hello, my friend!"
    var text = "Let's practise something!"
    var text2 = "It's time to practise!"
    var text3 = "Are you ready?"
    var text4 = "Good Luck and Have Fun!"
    var text5 = "You can win if you want"
    var text6 = "If you want it you will win!"
    var desc = "desc"

    lateinit var notification : NotificationChannel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)



//        val ad = Ad(this)
//        if (ad.randomMode(10)) {
//            ad.loadFullScreenAd("R-M-1708838-1")
//        }


        val sp = SharedPreferences(this)

        when (sp.getTHeme()) {
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



        var n = sp.getNumber()
        if (n > 0) {
            navController.navigate(R.id.SecondFragment)
        }

        else {
            n += 1
            sp.setNumber(n)
        }


        if (sp.getAdBlock()) {
            val timer = object : CountDownTimer(30 * 1000 * 60, 1000) {
                override fun onTick(p0: Long) {

                }

                override fun onFinish() {
                    sp.setAdBlock(false)
                }

            }
        }


        val fab = binding.fab

        fab.setColorFilter(Color.argb(255, 255, 255, 255));

        fab.setOnClickListener { view ->
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=pub%3AHeraxizator&c=apps&gl=NL"))
            startActivity(browserIntent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return when (item.itemId) {
            R.id.action_settings -> {

                navController.navigate(R.id.settingsFragment)
                true
            }

            R.id.action_rate -> {
                val rateintent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.myapp.mentalfire3&gl=NL"))
                startActivity(rateintent)
                true
            }

            R.id.action_other -> {
                val otherintent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=pub%3AHeraxizator&c=apps&gl=NL"))
                startActivity(otherintent)
                true
            }

            R.id.action_email -> {
                val i = Intent(Intent.ACTION_SEND)
                i.type = "message/rfc822"
                i.putExtra(Intent.EXTRA_EMAIL, arrayOf("m.a.sukhih@yandex.ru"))
                i.putExtra(Intent.EXTRA_SUBJECT, resources.getString(R.string.esubject))
                i.putExtra(Intent.EXTRA_TEXT, resources.getString(R.string.ebody))
                try {
                    startActivity(Intent.createChooser(i, resources.getString(R.string.echooser)))
                } catch (ex: ActivityNotFoundException) {

                }
                true
            }

            R.id.action_vcontact -> {
                val vkintent = Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/heraxizator"))
                startActivity(vkintent)
                true
            }

            R.id.action_back -> {
                navController.navigateUp()
                true
            }

            R.id.action_exit -> {
                finishAffinity()
                true
            }

            R.id.action_share -> {
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.myapp.mentalfire3&gl=NL")
                startActivity(Intent.createChooser(shareIntent,getString(R.string.action_share)))
                true
            }

            else -> {
                false
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onDestroy() {
        super.onDestroy()
        val sp = SharedPreferences(this)
        sp.setAdBlock(false)


        if (sp.getNotification()) {
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val intent = Intent(this, MainActivity :: class.java)
            val pending = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notification = NotificationChannel(cid, desc, NotificationManager.IMPORTANCE_HIGH)
                notification.enableLights(true)
                notification.lightColor = Color.YELLOW
                notification.enableVibration(false)
                notificationManager.createNotificationChannel(notification)

                val builder = Notification.Builder(this, cid)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setSmallIcon(R.drawable.splash)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_logo))
                    .setContentIntent(pending)

                val tvariant = (1..6).random()
                when (tvariant) {
                    1 -> {
                        builder.setContentText(text)
                    }

                    2 -> {
                        builder.setContentText(text2)
                    }

                    3 -> {
                        builder.setContentText(text3)
                    }

                    4 -> {
                        builder.setContentText(text4)
                    }

                    5 -> {
                        builder.setContentText(text5)
                    }

                    6 -> {
                        builder.setContentText(text6)
                    }

                }

                val titllev = (1..3).random()

                when (titllev) {
                    1 -> {
                        builder.setContentTitle(title)
                    }

                    2 -> {
                        builder.setContentTitle(title2)
                    }

                    3 -> {
                        builder.setContentTitle(title3)
                    }
                }

                val half = 30 * 60 * 1000
                val time = (half..half * 16).random()

                val timer = object : CountDownTimer(time.toLong(), 1000) {
                    override fun onTick(p0: Long) {

                    }

                    override fun onFinish() {
                        notificationManager.notify(1234, builder.build())
                    }

                }

                timer.start()

            } else {
                TODO("VERSION.SDK_INT < O")
            }
        }


    }
}