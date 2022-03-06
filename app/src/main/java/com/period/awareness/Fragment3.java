package com.period.awareness;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {
    private TextView option1,option2,option3;
    private androidx.cardview.widget.CardView option1card,option2card,option3card,next,hint;
    private String correctanswer,selected;
    private Animation wronganswer;
    private TextView quesnum,anshint,question;
    private String[] correct,options,questions,faqs;
    private int[] n;
    private Boolean enter=true;
    private int counter1=0,optioncounter=0,score=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment3,container,false);
        option1=(TextView) view.findViewById(R.id.option1);
        option2=(TextView) view.findViewById(R.id.option2);
        option3=(TextView) view.findViewById(R.id.option3);
        option1card=view.findViewById(R.id.option1card);
        option1card.setOnClickListener(listen);
        option2card=view.findViewById(R.id.option2card);
        option2card.setOnClickListener(listen);
        option3card=view.findViewById(R.id.option3card);
        option3card.setOnClickListener(listen);
        hint=view.findViewById(R.id.hint);
        anshint=view.findViewById(R.id.anshint);
        next=view.findViewById(R.id.next);
        next.setOnClickListener(listen);
        quesnum=view.findViewById(R.id.question_number);
        question=view.findViewById(R.id.question);
        correct=getResources().getStringArray(R.array.correctoptions);
        options=getResources().getStringArray(R.array.options);
        questions=getResources().getStringArray(R.array.questions);
        faqs=getResources().getStringArray(R.array.faqs);
        n=getResources().getIntArray(R.array.number_of_options);
        quesnum.setText(getString(R.string.question_number,1,5));
        shownextques();
        hint.setVisibility(View.INVISIBLE);
        wronganswer= AnimationUtils.loadAnimation(getContext(),R.anim.wrong_answer_animation);
        wronganswer.setRepeatCount(1);
        return view;
  }
    private View.OnClickListener listen=new View.OnClickListener(){
        @SuppressLint("ResourceAsColor")
        @Override
        public void onClick(View view) {
            int a=view.getId();
            if(view.getId()==R.id.next){
                if(selected.equals("")){
                    return;
                }
                else {
                    if(enter){
                        if(selected.equals(correctanswer)){
                            anshint.setText("Correct \n"+faqs[counter1-1]);
                            score++;
                        }
                        else{
                            //wrong
                            anshint.setText("Wrong \n"+correctanswer+"\n"+faqs[counter1-1]);
                        }
                        hint.setVisibility(View.VISIBLE);
                        hint.startAnimation(wronganswer);
                        enter=false;
                    }
                    else if(counter1==questions.length){
                        //end quiz and reset
                        Dialog dialog=new Dialog(getContext());
                        dialog.setContentView(R.layout.dialog_score);
                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                        ((TextView)dialog.findViewById(R.id.result)).setText("Congrats you have Scored "+score+" out of 5");
                        dialog.show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                try{
                                    dialog.dismiss();
                                }catch (Exception ignored){
                                }

                            }
                        },5000);
                        counter1=0;
                        optioncounter=0;
                        score=0;
                        return;
                    }
                    else{
                        shownextques();
                        enter=true;
                    }
                }
            }
            else{
                //selected
                switch (view.getId()){
                    case R.id.option1card:
                        option1card.setCardBackgroundColor(Color.parseColor("#FE8F8F"));
                        option2card.setCardBackgroundColor(Color.parseColor("#FFEDD3"));
                        option3card.setCardBackgroundColor(Color.parseColor("#FFEDD3"));
                        selected= (String) option1.getText();
                        break;

                    case R.id.option2card:
                        option2card.setCardBackgroundColor(Color.parseColor("#FE8F8F"));
                        option1card.setCardBackgroundColor(Color.parseColor("#FFEDD3"));
                        option3card.setCardBackgroundColor(Color.parseColor("#FFEDD3"));
                        selected= (String) option2.getText();
                        break;
                    case R.id.option3card:
                        option3card.setCardBackgroundColor(Color.parseColor("#FE8F8F"));
                        option2card.setCardBackgroundColor(Color.parseColor("#FFEDD3"));
                        option1card.setCardBackgroundColor(Color.parseColor("#FFEDD3"));
                        selected= (String) option3.getText();
                        break;
                }

            }
        }
    };
    private void shownextques(){
        hint.setVisibility(View.INVISIBLE);
        option3card.setCardBackgroundColor(Color.parseColor("#FFEDD3"));
        option2card.setCardBackgroundColor(Color.parseColor("#FFEDD3"));
        option1card.setCardBackgroundColor(Color.parseColor("#FFEDD3"));
        selected="";
        quesnum.setText(getString(R.string.question_number,counter1+1,5));
        question.setText(questions[counter1]);
        correctanswer=correct[counter1];
        if(n[counter1]==3){
            option3card.setVisibility(View.VISIBLE);
            option1.setText(options[optioncounter]);
            optioncounter++;
            option2.setText(options[optioncounter]);
            optioncounter++;
            option3.setText(options[optioncounter]);
            optioncounter++;
        }
        else{
            option3card.setVisibility(View.INVISIBLE);
            option1.setText(options[optioncounter]);
            optioncounter++;
            option2.setText(options[optioncounter]);
            optioncounter++;
        }
        counter1++;
    }
}