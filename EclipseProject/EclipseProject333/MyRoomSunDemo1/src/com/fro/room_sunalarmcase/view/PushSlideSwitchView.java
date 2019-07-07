package com.fro.room_sunalarmcase.view;


import com.example.myroomsundemo1.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;  
  
   
  
/** 
 * 鑷畾涔夊紑鍏虫寜閽紝  
 *   
 * 
 */  
public class PushSlideSwitchView extends View{  
    /** Switch搴曢儴鐏拌壊鏍峰紡鍥剧墖 */  
    private Bitmap mSwitchBgUnseleted;  
    /** Switch搴曢儴缁胯壊鏍峰紡鍥�  */  
    private Bitmap mSwitchBgSeleted;  
    /** Switch鐏拌壊鐨勭悆  */  
    private Bitmap mSwitchBallUnseleted;  
    /** Switch缁胯壊鐨勭悆  */  
    private Bitmap mSwitchBallSeleted;  
      
    private float mCurrentX = 0;  
    /** Switch 寮�鍏崇姸鎬侊紝榛樿鏄�  寮�锛歵rue  */  
    private boolean mSwitchOn = true;  
    /** Switch 鏈�澶хЩ鍔ㄨ窛绂�   */  
    private int mMoveLength;  
    /** 绗竴娆℃寜涓嬬殑鏈夋晥鍖哄煙 */  
    private float mLastX = 0;  
    /** 缁樺埗鐨勭洰鏍囧尯鍩熷ぇ灏�  */  
    private Rect mDest = null;   
    /** 鎴彇婧愬浘鐗囩殑澶у皬  */  
    /** Switch 绉诲姩鐨勫亸绉婚噺  */  
    private int mMoveDeltX = 0;  
    /** 鐢荤瑪宸ュ叿  */  
    private Paint mPaint = null;  
    /** Switch 鐘舵�佺洃鍚帴鍙�  */  
    private OnSwitchChangedListener switchListener = null;  
    private boolean mFlag = false;  
    /** enabled 灞炴�� 涓� true */  
    private boolean mEnabled = true;  
    /** 鏈�澶ч�忔槑搴︼紝灏辨槸涓嶉�忔槑 */  
    private final int MAX_ALPHA = 255;  
    /** 褰撳墠閫忔槑搴︼紝杩欓噷涓昏鐢ㄤ簬濡傛灉鎺т欢鐨別nable灞炴�т负false鏃跺�欒缃崐閫忔槑 锛屽嵆涓嶅彲浠ョ偣鍑� */  
    private int mAlpha = MAX_ALPHA;  
    /** Switch 鍒ゆ柇鏄惁鍦ㄦ嫋鍔� */  
    private boolean mIsScrolled =false;  
      
    public PushSlideSwitchView(Context context) {  
        this(context, null);  
    }  
  
    public PushSlideSwitchView(Context context, AttributeSet attrs) {  
        this(context, attrs, 0);  
    }  
  
    public PushSlideSwitchView(Context context, AttributeSet attrs, int defStyle) {  
        super(context, attrs, defStyle);  
        init();  
    }  
  
    /** 
     * 鍒濆鍖栫浉鍏宠祫婧� 
     */  
    public void init() {  
        mSwitchBgSeleted = BitmapFactory.decodeResource(getResources(),R.drawable.push_button_selected_bg);  
        mSwitchBgUnseleted = BitmapFactory.decodeResource(getResources(),R.drawable.push_button_unselected_bg);  
          
        mSwitchBallSeleted = BitmapFactory.decodeResource(getResources(),R.drawable.push_button_ball_selected);  
        mSwitchBallUnseleted = BitmapFactory.decodeResource(getResources(),R.drawable.push_button_ball_unselected);  
          
        mMoveLength = mSwitchBgSeleted.getWidth() - mSwitchBallSeleted.getWidth();  
        //缁樺埗鍖哄煙澶у皬  
        mDest = new Rect(0, 0, mSwitchBgSeleted.getWidth(), mSwitchBgSeleted.getHeight());  
          
        mPaint = new Paint();  
        mPaint.setAntiAlias(true);  
        mPaint.setAlpha(255);  
        mPaint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));  
    }  
  
    @Override  
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {  
        setMeasuredDimension(mSwitchBgSeleted.getWidth(), mSwitchBgSeleted.getHeight());  
    }  
  
    @Override  
    protected void onDraw(Canvas canvas) {  
        super.onDraw(canvas);  
          
        /*System.out.println("---onDraw()---mMoveDeltX= " + mMoveDeltX + 
                "  mSwitchBgUnseleted.getWidth()= " + mSwitchBgUnseleted.getWidth() + 
                "  mSwitchBallSeleted.getWidth()= " + mSwitchBallSeleted.getWidth() + 
                "  mMoveLength = " + mMoveLength);*/  
          
        canvas.saveLayerAlpha(new RectF(mDest), mAlpha, Canvas.MATRIX_SAVE_FLAG  
                | Canvas.CLIP_SAVE_FLAG | Canvas.HAS_ALPHA_LAYER_SAVE_FLAG  
                | Canvas.FULL_COLOR_LAYER_SAVE_FLAG  
                | Canvas.CLIP_TO_LAYER_SAVE_FLAG);  
        //濡傛灉鏄叧闂殑  
        if(!mSwitchOn){  
            if(mMoveDeltX > 0){//鍚戝彸婊戝姩浜�  
                if(mMoveDeltX < mMoveLength/2){//婊戝姩璺濈灏忎簬涓�鍗�  
                    canvas.drawBitmap(mSwitchBgUnseleted, 0, 0, null); //鐏拌壊鑳屾櫙  
                    canvas.drawBitmap(mSwitchBallUnseleted, mMoveDeltX, 0, null); //鐏拌壊鎸夐挳  
                }else{//婊戝姩璺濈澶т簬涓�鍗�  
                    canvas.drawBitmap(mSwitchBgSeleted, 0, 0, null); //缁胯壊鑳屾櫙  
                    canvas.drawBitmap(mSwitchBallSeleted, mMoveDeltX, 0, null); //缁胯壊鎸夐挳  
                }  
            }else{  
                canvas.drawBitmap(mSwitchBgUnseleted, 0, 0, null); //鐏拌壊鑳屾櫙  
                canvas.drawBitmap(mSwitchBallUnseleted, 0, 0, null); //鐏拌壊鎸夐挳  
            }  
        }else{  
            if(mMoveDeltX < 0){//鍚戝彸婊戝姩浜�  
                if(Math.abs(mMoveDeltX) < mMoveLength/2){//婊戝姩璺濈灏忎簬涓�鍗�  
                    canvas.drawBitmap(mSwitchBgSeleted, 0, 0, null); //缁胯壊鑳屾櫙  
                    canvas.drawBitmap(mSwitchBallSeleted, mSwitchBgSeleted.getWidth() - mSwitchBallSeleted.getWidth() + mMoveDeltX, 0, null); //缁胯壊鎸夐挳  
                }else{//婊戝姩璺濈澶т簬涓�鍗�  
                    canvas.drawBitmap(mSwitchBgUnseleted, 0, 0, null); //鐏拌壊鑳屾櫙  
                    canvas.drawBitmap(mSwitchBallUnseleted, mSwitchBgSeleted.getWidth() - mSwitchBallSeleted.getWidth() + mMoveDeltX, 0, null); //鐏拌壊鎸夐挳  
                }  
            }else{  
                canvas.drawBitmap(mSwitchBgSeleted, 0, 0, null); //缁胯壊鑳屾櫙  
                canvas.drawBitmap(mSwitchBallSeleted, mMoveLength, 0, null); //缁胯壊鎸夐挳  
            }  
        }  
          
        canvas.restore();  
    }  
  
    @Override  
    public boolean onTouchEvent(MotionEvent event) {  
        // TODO Auto-generated method stub  
        //濡傛灉Enabled灞炴�ц瀹氫负true,瑙︽懜鏁堟灉鎵嶆湁鏁�  
        if(!mEnabled){  
            return true;  
        }  
        switch (event.getAction()) {  
        case MotionEvent.ACTION_DOWN:  
            mLastX = event.getX();  
            break;  
        case MotionEvent.ACTION_MOVE:  
            mCurrentX = event.getX();  
            mMoveDeltX = (int) (mCurrentX - mLastX);  
            //System.out.println("===============" + mMoveDeltX);  
            if(mMoveDeltX > 3){  
                //璁剧疆浜�3杩欎釜璇樊璺濈锛屽彲浠ユ洿濂界殑瀹炵幇鐐瑰嚮鏁堟灉  
                mIsScrolled = true;  
            }  
            // 濡傛灉寮�鍏冲紑鐫�鍚戝彸婊戝姩锛屾垨鑰呭紑鍏冲叧鐫�鍚戝乏婊戝姩锛堣繖鏃跺�欐槸涓嶉渶瑕佸鐞嗙殑锛�  
            if ((mSwitchOn && mMoveDeltX > 0) || (!mSwitchOn && mMoveDeltX < 0)) {  
                mFlag = true;  
                mMoveDeltX = 0;  
            }  
  
            if (Math.abs(mMoveDeltX) > mMoveLength) {  
                mMoveDeltX = mMoveDeltX > 0 ? mMoveLength : -mMoveLength;  
            }  
            invalidate();  
            break;  
        case MotionEvent.ACTION_UP:  
            //濡傛灉娌℃湁婊戝姩杩囷紝灏辩湅浣滀竴娆＄偣鍑讳簨浠�  
            if(!mIsScrolled){  
                mMoveDeltX = mSwitchOn ? mMoveLength : -mMoveLength;  
                mSwitchOn = !mSwitchOn;  
                if (switchListener != null) {  
                    switchListener.onSwitchChange(this, mSwitchOn);  
                }  
                invalidate();  
                mMoveDeltX = 0;  
                break;  
            }  
            mIsScrolled = false;  
            if (Math.abs(mMoveDeltX) > 0 && Math.abs(mMoveDeltX) < mMoveLength / 2) {  
                mMoveDeltX = 0;  
                invalidate();  
            } else if (Math.abs(mMoveDeltX) > mMoveLength / 2  
                    && Math.abs(mMoveDeltX) <= mMoveLength) {  
                mMoveDeltX = mMoveDeltX > 0 ? mMoveLength : -mMoveLength;  
                mSwitchOn = !mSwitchOn;  
                if (switchListener != null) {  
                    switchListener.onSwitchChange(this, mSwitchOn);  
                }  
                invalidate();  
                mMoveDeltX = 0;  
            } else if (mMoveDeltX == 0 && mFlag) {  
                // 杩欐椂鍊欏緱鍒扮殑鏄笉闇�瑕佽繘琛屽鐞嗙殑锛屽洜涓哄凡缁弇ove杩囦簡  
                mMoveDeltX = 0;  
                mFlag = false;  
            }  
        default:  
            break;  
        }  
        invalidate();  
        return true;  
    }  
    /**  
     * 璁剧疆 switch 鐘舵�佺洃鍚�  
     * */  
    public void setOnChangeListener(OnSwitchChangedListener listener) {  
        switchListener = listener;  
    }  
    /**  
     * switch 寮�鍏崇洃鍚帴鍙� 
     *  */  
    public interface OnSwitchChangedListener{  
        public void onSwitchChange(PushSlideSwitchView switchView, boolean isChecked);  
    }  
      
    @Override  
    public void setEnabled(boolean enabled) {  
        // TODO Auto-generated method stub  
        mEnabled = enabled;  
        mAlpha = enabled ? MAX_ALPHA : MAX_ALPHA/2;  
        Log.d("enabled",enabled ? "true": "false");  
        super.setEnabled(enabled);  
        invalidate();  
    }  
      
    /** 鑷姩鍒ゆ柇鍒囨崲鑷崇浉鍙嶇殑灞炴�� : true -->false ;false -->true */  
    public void toggle() {  
        setChecked(!mSwitchOn);  
    }  
      
    /** 璁剧疆閫変腑鐨勭姸鎬侊紙閫変腑:true   闈為�変腑: false锛� */  
    public void setChecked(boolean checked) {  
        mSwitchOn = checked;  
        invalidate();  
    }  
}  