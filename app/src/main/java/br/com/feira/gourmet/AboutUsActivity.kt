package br.com.feira.gourmet

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_about_us.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_about_us.*
import android.os.Build
import android.text.Spanned



class AboutUsActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)
        setSupportActionBar(toolbar)

        supportActionBar!!.title = getString(R.string.action_about_us)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout_about, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout_about.addDrawerListener(toggle)
        toggle.syncState()

        nav_view_about.setNavigationItemSelectedListener(this)

        textView2.text = this.fromHtml(getString(R.string.title_about_us))

    }

    fun fromHtml(html: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(html)
        }
    }

    override fun onBackPressed() {
        if (drawer_layout_about.isDrawerOpen(GravityCompat.START)) {
            drawer_layout_about.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (item.itemId == R.id.action_settings) {
            val intent = AboutUsActivity.newIntent(this)
            startActivity(intent)
            return true
        } else {
            return super.onOptionsItemSelected(item)
        }

        return false
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        // Handle navigation view item clicks here.
//        when (item.itemId) {
//            R.id.nav_camera -> {
//                // Handle the camera action
//            }
//            R.id.nav_gallery -> {
//
//            }
//            R.id.nav_slideshow -> {
//
//            }
//            R.id.nav_manage -> {
//
//            }
//            R.id.nav_share -> {
//
//            }
//            R.id.nav_send -> {
//
//            }
//        }

        drawer_layout_about.closeDrawer(GravityCompat.START)
        return true
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, AboutUsActivity::class.java)
            return intent
        }
    }

}
