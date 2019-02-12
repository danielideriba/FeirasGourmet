package br.com.feira.gourmet

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

/**
 * Created by danielideriba on 11,February,2019
 */
class CategoriaActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoria)
        setSupportActionBar(toolbar)

        supportActionBar!!.title = getString(R.string.main_text1)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


        val mGrid = GridLayoutManager(this, 2)
        product_list.setLayoutManager(mGrid)
        product_list.setHasFixedSize(true)
        product_list.setNestedScrollingEnabled(false)
        val mAdapter = ProductAdapter(this@CategoriaActivity, getProductTestData())
        product_list.setAdapter(mAdapter)
    }

    private fun getProductTestData(): List<ProductObject> {
        val featuredProducts = ArrayList<ProductObject>()

        featuredProducts.add(ProductObject("Frutas", "ic_top_frutas"))
        featuredProducts.add(ProductObject("Verduras", "ic_top_verduras"))
        featuredProducts.add(ProductObject("Legumes", "ic_legumes"))
        featuredProducts.add(ProductObject("Laticínios", "ic_laticinios"))
        featuredProducts.add(ProductObject("Frutos do mar", "ic_frutos_do_mar"))
        featuredProducts.add(ProductObject("Nozes  e Castanhas", "ic_castanhas"))
        return featuredProducts
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
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
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, CategoriaActivity::class.java)
            return intent
        }
    }

}