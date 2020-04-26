package tally_counter.gp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import java.util.*;
import java.text.*;


public class MainActivity extends Activity {

	private LinearLayout bg;
	private LinearLayout top;
	private LinearLayout bgbtns;
	private LinearLayout linear1;
	private LinearLayout bgforad;
	private TextView nameofapp;
	private LinearLayout bgforcount;
	private TextView forcount;
	private Button countbtn;
	private Button resetbtn;
	private Button aboutbtn;
	private Button pw;
	private WebView webview1;

	private double count = 0;
	private AlertDialog.Builder d_q;

	private Intent goabout = new Intent();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		bg = (LinearLayout) findViewById(R.id.bg);
		top = (LinearLayout) findViewById(R.id.top);
		bgbtns = (LinearLayout) findViewById(R.id.bgbtns);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		bgforad = (LinearLayout) findViewById(R.id.bgforad);
		nameofapp = (TextView) findViewById(R.id.nameofapp);
		bgforcount = (LinearLayout) findViewById(R.id.bgforcount);
		forcount = (TextView) findViewById(R.id.forcount);
		countbtn = (Button) findViewById(R.id.countbtn);
		resetbtn = (Button) findViewById(R.id.resetbtn);
		aboutbtn = (Button) findViewById(R.id.aboutbtn);
		pw = (Button) findViewById(R.id.pw);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		webview1.setWebViewClient(new WebViewClient() {
				@Override
				public void onPageStarted(WebView _view, String _url, Bitmap _favicon) {

					super.onPageStarted(_view, _url, _favicon);
				}
				@Override
				public void onPageFinished(WebView _view, String _url) {

					super.onPageFinished(_view, _url);
				}
			});

		d_q = new AlertDialog.Builder(this);

		countbtn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _v) { 
					count++;
					forcount.setText(String.valueOf((long)(count)));
				}
			});
		resetbtn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _v) { 
					count = 0;
					forcount.setText("0");
				}
			});
		
		aboutbtn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _v) { 
					d_q.setTitle("About");
					d_q.setMessage("© Application by Primo (GP) - Supported by PWS | Site : pws-apps.blogspot.com\n\n Tally Counter V 1.9");
					d_q.setNeutralButton("OK", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {

							}
						});
					d_q.create().show();
				}
			});
			
			
		pw.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _v) { 
					d_q.setTitle("Muslim Praise Words");
					d_q.setMessage("Sobhan Allah ( Glory to God ) |  سبحان الله \n\n  Alhamd L Allah ( Thanks God ) | الحمدلله  \n\n  Astghfer Allah ( Ask forgiveness of God ) | استغفر الله  \n\n  Allah Akbar ( God is the Greatest ) | الله اكبر \n\n La Elah Ella Allah ( No God except Allah ) | لا اله الا الله \n\n  Allahoma Saly W Salem W Barek Ala Sydina Mohammed ( God blessings and peace upon our Prophet Muhammad ) | اللهم صلي وسلم وبارك على سيدنا محمد \n\n  La Elah Ella Ant Sobhank Eny Kont Mn Alzalemyn ( No god but You Glory I oppressors ) | لا اله الا انت سبحانك اني كنت من الظالمين \n\n  Besm Allah Allazy La Yador Maa Esmh Shea Fe Alard Wla Fe Alsamaa W hoa Alsamea Alaalem ( In the name of God, who not harms with his name something in the earth and not in heaven and He is the All-Hearing ) | بسم الله الذي لا يضر مع اسمه شئ في الارض ولا في السماء وهو السميع العليم  ");
					
					d_q.setNeutralButton("OK", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {

							}
						});
					d_q.create().show();
				}
			});
			
	}
	
	

	private void  initializeLogic() {
		count = 0;
		forcount.setText("0");
		webview1.loadUrl("file:///android_asset/mob_ads.html");
		webview1.clearCache(true);
	}

	

	// created automatically
	private void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}

	private int getRandom(int _minValue ,int _maxValue){
		Random random = new Random();
		return random.nextInt(_maxValue - _minValue + 1) + _minValue;
	}

	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
				_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}

}

