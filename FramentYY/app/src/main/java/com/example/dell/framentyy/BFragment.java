package com.example.dell.framentyy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment implements View.OnClickListener {
    private EditText ed;
    private EditText ed1;
    private EditText ed2;
    private Button yybu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_b, container, false);

        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        ed = (EditText) inflate.findViewById(R.id.ed);
        ed1 = (EditText) inflate.findViewById(R.id.ed1);
        ed2 = (EditText) inflate.findViewById(R.id.ed2);
        yybu = (Button) inflate.findViewById(R.id.yybu);

        yybu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yybu:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String edString = ed.getText().toString().trim();
        if (TextUtils.isEmpty(edString)) {
            Toast.makeText(getContext(), "请输入名字", Toast.LENGTH_SHORT).show();
            return;
        }

        String ed1String = ed1.getText().toString().trim();
        if (TextUtils.isEmpty(ed1String)) {
            Toast.makeText(getContext(), "请输入性别", Toast.LENGTH_SHORT).show();
            return;
        }

        String ed2String = ed2.getText().toString().trim();
        if (TextUtils.isEmpty(ed2String)) {
            Toast.makeText(getContext(), "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        Intent intent = new Intent();
        intent.setAction("dd");
        intent.putExtra("p",edString);
        intent.putExtra("pp",ed1String);
        intent.putExtra("pp1",ed2String);
        getActivity().sendBroadcast(intent);
    }
}
