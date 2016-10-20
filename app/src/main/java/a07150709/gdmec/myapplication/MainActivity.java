package a07150709.gdmec.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    private TextView tView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tView=(TextView) this.findViewById(R.id.textView);
        Button button=(Button)this.findViewById(R.id.button);
        Button button1=(Button)this.findViewById(R.id.button1);
        Button button2=(Button)this.findViewById(R.id.button2);
        Button button3= (Button)this.findViewById(R.id.button3);
        Button button4= (Button)this.findViewById(R.id.button4);
        Button button5= (Button)this.findViewById(R.id.button5);
        Button button6= (Button)this.findViewById(R.id.button6);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button:
                        dialog1();
                        break;
                    case R.id.button1:
                        dialog2();
                        break;
                    case R.id.button2:
                        dialog3();
                        break;
                    case R.id.button3:
                        dialog4();
                        break;
                    case R.id.button4:
                        dialog5();
                        break;
                    case R.id.button5:
                        dialog6();
                        break;
                    case R.id.button6:
                        dialog7();
                }
            }
        };

        button.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
    }

    private void dialog7() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.diydialog,null);
        final EditText editText = (EditText) layout.findViewById(R.id.editText1);
        dialog = new AlertDialog.Builder(MainActivity.this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是："+editText.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }

    private void dialog6() {
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener mlistener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str ="你选择了:"+item[which];
                tView.setText(str);
            }
        };
        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setItems(item,mlistener);
        dialog = builder.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }

    private void dialog5() {
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener mlistener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for (int i = 0;i<bSelect.length;i++){
                    bSelect[i] =false;
                    bSelect[which] =true;
                }

            }
        };
        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setSingleChoiceItems(item,-1,mlistener);
        dialog = builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "";
                for (int i = 0; i <bSelect.length;i++){
                    if (bSelect[i]){
                        str = str +"\n"+item[i];
                    }
                }tView.setText(str);
            }
            ;                };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }

    private void dialog4() {
        final String item[] = new String[] {"北京","上海","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mlistener = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which] = isChecked;
            }
        };
        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMultiChoiceItems(item,null,mlistener);
        dialog = builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener listener =new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "";
                for(int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str = str + "\n" +item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }

    private void dialog3() {
        dialog = new AlertDialog.Builder(MainActivity.this).create();
        dialog.setTitle("请输入");
        dialog.setMessage("你平时忙吗");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText editText = new EditText(MainActivity.this);
        dialog.setView(editText);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是"+editText.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.show();
    }

    private void dialog2() {
        dialog = new AlertDialog.Builder(MainActivity.this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你平时忙吗?");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str = "平时很忙";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str = "平时轻松";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str = "平时一般";
                        break;
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"忙碌",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"不忙",listener);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",listener);
        dialog.show();
    }

    private void dialog1() {
        dialog = new AlertDialog.Builder(MainActivity.this).create();
        dialog.setTitle("提示");
        dialog.setMessage("确定退出吗?");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    //关闭当前活动
                    MainActivity.this.finish();
                }else if(which == DialogInterface.BUTTON_NEGATIVE)
                    dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        dialog.show();
    }
};