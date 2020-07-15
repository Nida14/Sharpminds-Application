package com.roboticsworld.sharpminds;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.roboticsworld.sharpminds.abacus_classes.AddSub;
import com.roboticsworld.sharpminds.abacus_classes.Counting;
import com.roboticsworld.sharpminds.abacus_classes.Family;
import com.roboticsworld.sharpminds.abacus_classes.House10;
import com.roboticsworld.sharpminds.abacus_classes.House5;
import com.roboticsworld.sharpminds.abacus_classes.sound;

import java.util.ArrayList;

public class AbacusFragment extends Fragment {

    // Class Variables
    Counting counting;
    AddSub addSub;
    House5 house5;
    House10 house10;
    Family family;
    // Variables Declaration
    ArrayList<Integer> aList = new ArrayList<Integer>();
    int correct_count=0,sum=0;
    Bundle bundle;
    ImageView bd_up_1,bd_up_2,bd_up_3,bd_up_4,im1;
    ImageView bd_dn_1_1,bd_dn_1_2,bd_dn_1_3,bd_dn_1_4;
    ImageView bd_dn_2_1,bd_dn_2_2,bd_dn_2_3,bd_dn_2_4;
    ImageView bd_dn_3_1,bd_dn_3_2,bd_dn_3_3,bd_dn_3_4;
    ImageView bd_dn_4_1,bd_dn_4_2,bd_dn_4_3,bd_dn_4_4;
    ImageView reset;
    int score = 0;
    View view;
    TextView txt_score,txt_Q_count;
    TextView[] Q_txt = new TextView[6];
    double pos_top1=0,pos_top2=0,pos_top3=0,pos_top4=0,pos_up=0,def=0;
    boolean is_loaded_axis = false,new_Question=true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_abacus, container, false);

        txt_score = view.findViewById(R.id.score);
        Q_txt[0] = view.findViewById(R.id.Q_txt1);
        Q_txt[1] = view.findViewById(R.id.Q_txt2);
        Q_txt[2] = view.findViewById(R.id.Q_txt3);
        Q_txt[3] = view.findViewById(R.id.Q_txt4);
        Q_txt[4] = view.findViewById(R.id.Q_txt5);
        Q_txt[5] = view.findViewById(R.id.Q_txt6);
        txt_Q_count = view.findViewById(R.id.question_count);
        txt_score.setText("0");
        reset = view.findViewById(R.id.reset);
        // UPPER BEADS
        bd_up_1 = view.findViewById(R.id.bd_up_1);
        bd_up_2 = view.findViewById(R.id.bd_up_2);
        bd_up_3 = view.findViewById(R.id.bd_up_3);
        bd_up_4 = view.findViewById(R.id.bd_up_4);

        // LOWER BEADS
        bd_dn_1_1 = view.findViewById(R.id.bd_dn_1_1);
        bd_dn_1_2 = view.findViewById(R.id.bd_dn_1_2);
        bd_dn_1_3 = view.findViewById(R.id.bd_dn_1_3);
        bd_dn_1_4 = view.findViewById(R.id.bd_dn_1_4);

        bd_dn_2_1 = view.findViewById(R.id.bd_dn_2_1);
        bd_dn_2_2 = view.findViewById(R.id.bd_dn_2_2);
        bd_dn_2_3 = view.findViewById(R.id.bd_dn_2_3);
        bd_dn_2_4 = view.findViewById(R.id.bd_dn_2_4);

        bd_dn_3_1 = view.findViewById(R.id.bd_dn_3_1);
        bd_dn_3_2 = view.findViewById(R.id.bd_dn_3_2);
        bd_dn_3_3 = view.findViewById(R.id.bd_dn_3_3);
        bd_dn_3_4 = view.findViewById(R.id.bd_dn_3_4);

        bd_dn_4_1 = view.findViewById(R.id.bd_dn_4_1);
        bd_dn_4_2 = view.findViewById(R.id.bd_dn_4_2);
        bd_dn_4_3 = view.findViewById(R.id.bd_dn_4_3);
        bd_dn_4_4 = view.findViewById(R.id.bd_dn_4_4);

        // SETTING CLICK LISTNERS
        // uppers
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset_all();
            }
        });
        bd_up_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upper_beads(v);
            }
        });
        bd_up_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upper_beads(v);
            }
        });
        bd_up_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upper_beads(v);
            }
        });
        bd_up_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upper_beads(v);
            }
        });

        // lower
        bd_dn_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lower_beads(v);
            }
        });
        bd_dn_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lower_beads(v);
            }
        });
        bd_dn_1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lower_beads(v);
            }
        });
        bd_dn_1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lower_beads(v);
            }
        });

        bd_dn_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lower_beads(v);
            }
        });
        bd_dn_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lower_beads(v);
            }
        });
        bd_dn_2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lower_beads(v);
            }
        });
        bd_dn_2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lower_beads(v);
            }
        });

        bd_dn_3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lower_beads(v);
            }
        });
        bd_dn_3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lower_beads(v);
            }
        });
        bd_dn_3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lower_beads(v);
            }
        });
        bd_dn_3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lower_beads(v);
            }
        });

        bd_dn_4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lower_beads(v);
            }
        });
        bd_dn_4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lower_beads(v);
            }
        });
        bd_dn_4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lower_beads(v);
            }
        });
        bd_dn_4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lower_beads(v);
            }
        });

        bundle = getArguments();
        String key = bundle.getString("key");
        switch (key)
        {
            case "forward_counting":            //      counting
                init_counting();
                counting.status[0] = true;
                break;
            case "backward_counting":
                init_counting();
                counting.status[1] = true;
                break;
            case "random_counting":
                init_counting();
                counting.status[2] = true;
                break;
            case "counting":                    //      addsub
                init_addsub();
                addSub.status[0] = true;
                break;
            case "five":
                init_addsub();
                addSub.status[1] = true;
                break;
            case "six":
                init_addsub();
                addSub.status[2] = true;
                break;
            case "seven":
                init_addsub();
                addSub.status[3] = true;
                break;
            case "eight":
                init_addsub();
                addSub.status[4] = true;
                break;
            case "nine":
                init_addsub();
                addSub.status[5] = true;
                break;

            case "h5_plus1":                     //         house of +5
                init_house5();
                house5.status[0] = true;
                break;
            case "h5_plus2":
                init_house5();
                house5.status[1] = true;
                break;
            case "h5_plus3":
                init_house5();
                house5.status[2] = true;
                break;
            case "h5_plus4":
                init_house5();
                house5.status[3] = true;
                break;
            case "h5_random":
                init_house5();
                house5.status[4] = true;
                break;
            case "h5_minus1":                     //         house of -5
                init_house5();
                house5.status[5] = true;
                break;
            case "h5_minus2":
                init_house5();
                house5.status[6] = true;
                break;
            case "h5_minus3":
                init_house5();
                house5.status[7] = true;
                break;
            case "h5_minus4":
                init_house5();
                house5.status[8] = true;
                break;
            case "h5_random_minus":
                init_house5();
                house5.status[9] = true;
                break;

            case "h10_plus1":                     //         house of +10
                init_house10();
                house10.status[0] = true;
                break;
            case "h10_plus2":
                init_house10();
                house10.status[1] = true;
                break;
            case "h10_plus3":
                init_house10();
                house10.status[2] = true;
                break;
            case "h10_plus4":
                init_house10();
                house10.status[3] = true;
                break;
            case "h10_plus5":
                init_house10();
                house10.status[4] = true;
                break;
            case "h10_plus6":
                init_house10();
                house10.status[5] = true;
                break;
            case "h10_plus7":
                init_house10();
                house10.status[6] = true;
                break;
            case "h10_plus8":
                init_house10();
                house10.status[7] = true;
                break;
            case "h10_plus9":
                init_house10();
                house10.status[8] = true;
                break;
            case "h10_random_plus":
                init_house10();
                house10.status[9] = true;
                break;
            case "h10_minus1":                     //         house of -10
                init_house10();
                house10.status[10] = true;
                break;
            case "h10_minus2":
                init_house10();
                house10.status[11] = true;
                break;
            case "h10_minus3":
                init_house10();
                house10.status[12] = true;
                break;
            case "h10_minus4":
                init_house10();
                house10.status[13] = true;
                break;
            case "h10_minus5":
                init_house10();
                house10.status[14] = true;
                break;
            case "h10_minus6":
                init_house10();
                house10.status[15] = true;
                break;
            case "h10_minus7":
                init_house10();
                house10.status[16] = true;
                break;
            case "h10_minus8":
                init_house10();
                house10.status[17] = true;
                break;
            case "h10_minus9":
                init_house10();
                house10.status[18] = true;
                break;
            case "h10_random_minus":
                init_house10();
                house10.status[19] = true;
                break;

            case "fam_plus6":                     //          Family
                init_family();
                family.status[0] = true;
                break;
            case "fam_plus7":
                init_family();
                family.status[1] = true;
                break;
            case "fam_plus8":
                init_family();
                family.status[2] = true;
                break;
            case "fam_plus9":
                init_family();
                family.status[3] = true;
                break;
            case "fam_random_plus":
                init_family();
                family.status[4] = true;
                break;
            case "fam_minus1":
                init_family();
                family.status[5] = true;
                break;
            case "fam_minus7":
                init_family();
                family.status[6] = true;
                break;
            case "fam_minus8":
                init_family();
                family.status[7] = true;
                break;
            case "fam_minus9":
                init_family();
                family.status[8] = true;
                break;
            case "fam_random_minus":
                init_family();
                family.status[9] = true;
                break;
        }
        triger();
        Q_txt[0].setTextColor(Color.parseColor("#FF0000"));
        return view;
    }

    public void init_counting()
    {
        counting = new Counting();
    }
    public void init_addsub()
    {
        addSub = new AddSub(getContext());
    }
    public void init_house5()
    {
        house5 = new House5(getContext());
    }
    public void init_house10()
    {
        house10 = new House10(getContext());
    }
    public void init_family()
    {
        family = new Family(getContext());
    }

    public void write(int a)
    {
        score += a;
        txt_score.setText(score+"");
    }
    public void load_axis()
    {
        if(!is_loaded_axis)
        {
            pos_up = bd_up_1.getY();
            pos_top1 = bd_dn_1_1.getY();
            pos_top2 = bd_dn_1_2.getY();
            pos_top3 = bd_dn_1_3.getY();
            pos_top4 = bd_dn_1_4.getY();
            def = pos_top2 - pos_top1 + 29;
            is_loaded_axis = true;
        }
    }

    public void reset_all(){
        load_axis();
        sound.reset(getContext());
        score = 0;
        write(0);
        bd_up_1.setY((float) pos_up);
        bd_up_2.setY((float) pos_up);
        bd_up_3.setY((float) pos_up);
        bd_up_4.setY((float) pos_up);

        bd_dn_1_1.setY((float) pos_top1);
        bd_dn_1_2.setY((float) pos_top2);
        bd_dn_1_3.setY((float) pos_top3);
        bd_dn_1_4.setY((float) pos_top4);

        bd_dn_2_1.setY((float) pos_top1);
        bd_dn_2_2.setY((float) pos_top2);
        bd_dn_2_3.setY((float) pos_top3);
        bd_dn_2_4.setY((float) pos_top4);

        bd_dn_3_1.setY((float) pos_top1);
        bd_dn_3_2.setY((float) pos_top2);
        bd_dn_3_3.setY((float) pos_top3);
        bd_dn_3_4.setY((float) pos_top4);

        bd_dn_4_1.setY((float) pos_top1);
        bd_dn_4_2.setY((float) pos_top2);
        bd_dn_4_3.setY((float) pos_top3);
        bd_dn_4_4.setY((float) pos_top4);
    }

    public void upper_beads(View v)
    {
        load_axis();
        double y = 94;
        if(v.getId()== R.id.bd_up_1 )
        {
            if(v.getY() == pos_up)
            {
                v.setY((float)(pos_up + y));
                write(5);
            }
            else if(v.getY() == y)
            {
                v.setY((float) pos_up);
                write(-5);
            }
        }
        if( v.getId()== R.id.bd_up_2 )
        {
            if(v.getY() == pos_up)
            {
                v.setY((float)(pos_up + y));
                write(50);
            }
            else if(v.getY() == y)
            {
                v.setY((float) pos_up);
                write(-50);
            }
        }
        if(v.getId()== R.id.bd_up_3)
        {
            if(v.getY() == pos_up)
            {
                v.setY((float)(pos_up + y));
                write(500);
            }
            else if(v.getY() == y)
            {
                v.setY((float) pos_up);
                write(-500);
            }
        }
        if(v.getId()== R.id.bd_up_4)
        {
            if(v.getY() == pos_up)
            {
                v.setY((float)(pos_up + y));
                write(5000);
            }
            else if(v.getY() == y)
            {
                v.setY((float) pos_up);
                write(-5000);
            }
        }
        triger();
    }

    public void lower_beads(View v)
    {
        load_axis();
        // for unit
        if(v.getId() == R.id.bd_dn_1_1)
        {
            if(bd_dn_1_1.getY() == pos_top1)
            {
                bd_dn_1_1.setY((float)(pos_top1-def));
                write(1);
            }
            else
            {
                if(bd_dn_1_2.getY() != pos_top2)
                {
                    write(-1);
                }
                if(bd_dn_1_3.getY() != pos_top3)
                {
                    write(-1);
                }
                if(bd_dn_1_4.getY() != pos_top4)
                {
                    write(-1);
                }
                write(-1);
                bd_dn_1_1.setY((float)pos_top1);
                bd_dn_1_2.setY((float)pos_top2);
                bd_dn_1_3.setY((float)pos_top3);
                bd_dn_1_4.setY((float)pos_top4);
            }
        }
        if(v.getId() == R.id.bd_dn_1_2)
        {
            if(bd_dn_1_2.getY() == pos_top2)
            {
                if(bd_dn_1_1.getY() == pos_top1)
                {
                    write(1);
                }
                write(1);
                bd_dn_1_1.setY((float)(pos_top1-def));
                bd_dn_1_2.setY((float)(pos_top2-def));
            }
            else
            {
                if(bd_dn_1_3.getY() != pos_top3)
                {
                    write(-1);
                }
                if(bd_dn_1_4.getY() != pos_top4)
                {
                    write(-1);
                }
                write(-1);
                bd_dn_1_2.setY((float)(pos_top2));
                bd_dn_1_3.setY((float)(pos_top3));
                bd_dn_1_4.setY((float)(pos_top4));
            }
        }
        if(v.getId() == R.id.bd_dn_1_3)
        {
            if(bd_dn_1_3.getY() == pos_top3)
            {
                if(bd_dn_1_1.getY() == pos_top1)
                {
                    write(1);
                }
                if(bd_dn_1_2.getY() == pos_top2)
                {
                    write(1);
                }
                write(1);
                bd_dn_1_1.setY((float)(pos_top1-def));
                bd_dn_1_2.setY((float)(pos_top2-def));
                bd_dn_1_3.setY((float)(pos_top3-def));
            }
            else
            {
                if(bd_dn_1_4.getY() != pos_top4)
                {
                    write(-1);
                }
                write(-1);
                bd_dn_1_3.setY((float)pos_top3);
                bd_dn_1_4.setY((float)pos_top4);
            }
        }
        if(v.getId() == R.id.bd_dn_1_4)
        {
            if(bd_dn_1_4.getY() == pos_top4)
            {
                if(bd_dn_1_1.getY() == pos_top1)
                {
                    write(1);
                }
                if(bd_dn_1_2.getY() == pos_top2)
                {
                    write(1);
                }
                if(bd_dn_1_3.getY() == pos_top3)
                {
                    write(1);
                }
                write(1);
                bd_dn_1_1.setY((float)(pos_top1-def));
                bd_dn_1_2.setY((float)(pos_top2-def));
                bd_dn_1_3.setY((float)(pos_top3-def));
                bd_dn_1_4.setY((float)(pos_top4-def));
            }
            else
            {
                write(-1);
                bd_dn_1_4.setY((float)pos_top4);
            }
        }

        // for tens
        if(v.getId() == R.id.bd_dn_2_1)
        {
            if(bd_dn_2_1.getY() == pos_top1)
            {
                bd_dn_2_1.setY((float)(pos_top1-def));
                write(10);
            }
            else
            {
                if(bd_dn_2_2.getY() != pos_top2)
                {
                    write(-10);
                }
                if(bd_dn_2_3.getY() != pos_top3)
                {
                    write(-10);
                }
                if(bd_dn_2_4.getY() != pos_top4)
                {
                    write(-10);
                }
                write(-10);
                bd_dn_2_1.setY((float)pos_top1);
                bd_dn_2_2.setY((float)pos_top2);
                bd_dn_2_3.setY((float)pos_top3);
                bd_dn_2_4.setY((float)pos_top4);
            }
        }
        if(v.getId() == R.id.bd_dn_2_2)
        {
            if(bd_dn_2_2.getY() == pos_top2)
            {
                if(bd_dn_2_1.getY() == pos_top1)
                {
                    write(10);
                }
                write(10);
                bd_dn_2_1.setY((float)(pos_top1-def));
                bd_dn_2_2.setY((float)(pos_top2-def));
            }
            else
            {
                if(bd_dn_2_3.getY() != pos_top3)
                {
                    write(-10);
                }
                if(bd_dn_2_4.getY() != pos_top4)
                {
                    write(-10);
                }
                write(-10);
                bd_dn_2_2.setY((float)(pos_top2));
                bd_dn_2_3.setY((float)(pos_top3));
                bd_dn_2_4.setY((float)(pos_top4));
            }
        }
        if(v.getId() == R.id.bd_dn_2_3)
        {
            if(bd_dn_2_3.getY() == pos_top3)
            {
                if(bd_dn_2_1.getY() == pos_top1)
                {
                    write(10);
                }
                if(bd_dn_2_2.getY() == pos_top2)
                {
                    write(10);
                }
                write(10);
                bd_dn_2_1.setY((float)(pos_top1-def));
                bd_dn_2_2.setY((float)(pos_top2-def));
                bd_dn_2_3.setY((float)(pos_top3-def));
            }
            else
            {
                if(bd_dn_2_4.getY() != pos_top4)
                {
                    write(-10);
                }
                write(-10);
                bd_dn_2_3.setY((float)pos_top3);
                bd_dn_2_4.setY((float)pos_top4);
            }
        }
        if(v.getId() == R.id.bd_dn_2_4)
        {
            if(bd_dn_2_4.getY() == pos_top4)
            {
                if(bd_dn_2_1.getY() == pos_top1)
                {
                    write(10);
                }
                if(bd_dn_2_2.getY() == pos_top2)
                {
                    write(10);
                }
                if(bd_dn_2_3.getY() == pos_top3)
                {
                    write(10);
                }
                write(10);
                bd_dn_2_1.setY((float)(pos_top1-def));
                bd_dn_2_2.setY((float)(pos_top2-def));
                bd_dn_2_3.setY((float)(pos_top3-def));
                bd_dn_2_4.setY((float)(pos_top4-def));
            }
            else
            {
                write(-10);
                bd_dn_2_4.setY((float)pos_top4);
            }
        }

        // for hundreds
        if(v.getId() == R.id.bd_dn_3_1)
        {
            if(bd_dn_3_1.getY() == pos_top1)
            {
                bd_dn_3_1.setY((float)(pos_top1-def));
                write(100);
            }
            else
            {
                if(bd_dn_3_2.getY() != pos_top2)
                {
                    write(-100);
                }
                if(bd_dn_3_3.getY() != pos_top3)
                {
                    write(-100);
                }
                if(bd_dn_3_4.getY() != pos_top4)
                {
                    write(-100);
                }
                write(-100);
                bd_dn_3_1.setY((float)pos_top1);
                bd_dn_3_2.setY((float)pos_top2);
                bd_dn_3_3.setY((float)pos_top3);
                bd_dn_3_4.setY((float)pos_top4);
            }
        }
        if(v.getId() == R.id.bd_dn_3_2)
        {
            if(bd_dn_3_2.getY() == pos_top2)
            {
                if(bd_dn_3_1.getY() == pos_top1)
                {
                    write(100);
                }
                write(100);
                bd_dn_3_1.setY((float)(pos_top1-def));
                bd_dn_3_2.setY((float)(pos_top2-def));
            }
            else
            {
                if(bd_dn_3_3.getY() != pos_top3)
                {
                    write(-100);
                }
                if(bd_dn_3_4.getY() != pos_top4)
                {
                    write(-100);
                }
                write(-100);
                bd_dn_3_2.setY((float)(pos_top2));
                bd_dn_3_3.setY((float)(pos_top3));
                bd_dn_3_4.setY((float)(pos_top4));
            }
        }
        if(v.getId() == R.id.bd_dn_3_3)
        {
            if(bd_dn_3_3.getY() == pos_top3)
            {
                if(bd_dn_3_1.getY() == pos_top1)
                {
                    write(100);
                }
                if(bd_dn_3_2.getY() == pos_top2)
                {
                    write(100);
                }
                write(100);
                bd_dn_3_1.setY((float)(pos_top1-def));
                bd_dn_3_2.setY((float)(pos_top2-def));
                bd_dn_3_3.setY((float)(pos_top3-def));
            }
            else
            {
                if(bd_dn_1_4.getY() != pos_top4)
                {
                    write(-100);
                }
                write(-100);
                bd_dn_3_3.setY((float)pos_top3);
                bd_dn_3_4.setY((float)pos_top4);
            }
        }
        if(v.getId() == R.id.bd_dn_3_4)
        {
            if(bd_dn_3_4.getY() == pos_top4)
            {
                if(bd_dn_3_1.getY() == pos_top1)
                {
                    write(100);
                }
                if(bd_dn_3_2.getY() == pos_top2)
                {
                    write(100);
                }
                if(bd_dn_3_3.getY() == pos_top3)
                {
                    write(100);
                }
                write(100);
                bd_dn_3_1.setY((float)(pos_top1-def));
                bd_dn_3_2.setY((float)(pos_top2-def));
                bd_dn_3_3.setY((float)(pos_top3-def));
                bd_dn_3_4.setY((float)(pos_top4-def));
            }
            else
            {
                write(-100);
                bd_dn_3_4.setY((float)pos_top4);
            }
        }

        // for thousands
        if(v.getId() == R.id.bd_dn_4_1)
        {
            if(bd_dn_4_1.getY() == pos_top1)
            {
                bd_dn_4_1.setY((float)(pos_top1-def));
                write(1000);
            }
            else
            {
                if(bd_dn_4_2.getY() != pos_top2)
                {
                    write(-1000);
                }
                if(bd_dn_4_3.getY() != pos_top3)
                {
                    write(-1000);
                }
                if(bd_dn_4_4.getY() != pos_top4)
                {
                    write(-1000);
                }
                write(-1000);
                bd_dn_4_1.setY((float)pos_top1);
                bd_dn_4_2.setY((float)pos_top2);
                bd_dn_4_3.setY((float)pos_top3);
                bd_dn_4_4.setY((float)pos_top4);
            }
        }
        if(v.getId() == R.id.bd_dn_4_2)
        {
            if(bd_dn_4_2.getY() == pos_top2)
            {
                if(bd_dn_4_1.getY() == pos_top1)
                {
                    write(1000);
                }
                write(1000);
                bd_dn_4_1.setY((float)(pos_top1-def));
                bd_dn_4_2.setY((float)(pos_top2-def));
            }
            else
            {
                if(bd_dn_4_3.getY() != pos_top3)
                {
                    write(-1000);
                }
                if(bd_dn_4_4.getY() != pos_top4)
                {
                    write(-1000);
                }
                write(-1000);
                bd_dn_4_2.setY((float)(pos_top2));
                bd_dn_4_3.setY((float)(pos_top3));
                bd_dn_4_4.setY((float)(pos_top4));
            }
        }
        if(v.getId() == R.id.bd_dn_4_3)
        {
            if(bd_dn_4_3.getY() == pos_top3)
            {
                if(bd_dn_4_1.getY() == pos_top1)
                {
                    write(1000);
                }
                if(bd_dn_4_2.getY() == pos_top2)
                {
                    write(1000);
                }
                write(1000);
                bd_dn_4_1.setY((float)(pos_top1-def));
                bd_dn_4_2.setY((float)(pos_top2-def));
                bd_dn_4_3.setY((float)(pos_top3-def));
            }
            else
            {
                if(bd_dn_4_4.getY() != pos_top4)
                {
                    write(-1000);
                }
                write(-1000);
                bd_dn_4_3.setY((float)pos_top3);
                bd_dn_4_4.setY((float)pos_top4);
            }
        }
        if(v.getId() == R.id.bd_dn_4_4)
        {
            if(bd_dn_4_4.getY() == pos_top4)
            {
                if(bd_dn_4_1.getY() == pos_top1)
                {
                    write(1000);
                }
                if(bd_dn_4_2.getY() == pos_top2)
                {
                    write(1000);
                }
                if(bd_dn_4_3.getY() == pos_top3)
                {
                    write(1000);
                }
                write(1000);
                bd_dn_4_1.setY((float)(pos_top1-def));
                bd_dn_4_2.setY((float)(pos_top2-def));
                bd_dn_4_3.setY((float)(pos_top3-def));
                bd_dn_4_4.setY((float)(pos_top4-def));
            }
            else
            {
                write(-1000);
                bd_dn_4_4.setY((float)pos_top4);
            }
        }
        triger();
    }

//************************************************************************************
//                          Control Category functions
//************************************************************************************

    public void triger()
    {
        if(counting != null)
        {
            int ans = counting.triger(score,getContext());
            Q_txt[0].setText(ans+"");
        }
        else if(addSub != null)
        {
            if(score == 0 && new_Question)
            {
                new_Question = false;
                aList = addSub.getQuestion();
                if(setTexts())
                {
                    txt_Q_count.setText(addSub.get_Q_count());
                    sum=aList.get(correct_count);
                }
            }
            else
            {
                if(score == sum)
                {
                    Q_txt[correct_count].setTextColor(Color.GRAY);
                    Q_txt[correct_count+1].setTextColor(Color.RED);
                    correct_count++;
                    if(correct_count == aList.size())
                    {
                        sound.correct(getContext());
                        reset_all();
                        Q_txt[correct_count-1].setTextColor(Color.GRAY);
                        aList = addSub.getQuestion();
                        if(setTexts())
                        {
                            txt_Q_count.setText(addSub.get_Q_count());
                            correct_count = 0;
                            sum=aList.get(correct_count);
                        }
                    }
                    else
                    {
                        sum+=aList.get(correct_count);
                    }
                }
            }
        }
        else if(house5 != null)
        {
            if(score == 0 && new_Question)
            {
                new_Question = false;
                aList = house5.getQuestion();
                if(setTexts())
                {
                    txt_Q_count.setText(house5.get_Q_count());
                    sum=aList.get(correct_count);
                }
            }
            else
            {
                if(score == sum)
                {
                    Q_txt[correct_count].setTextColor(Color.GRAY);
                    Q_txt[correct_count+1].setTextColor(Color.RED);
                    correct_count++;
                    if(correct_count == aList.size())
                    {
                        sound.correct(getContext());
                        reset_all();
                        Q_txt[correct_count-1].setTextColor(Color.GRAY);
                        aList = house5.getQuestion();
                        if(setTexts())
                        {
                            txt_Q_count.setText(house5.get_Q_count());
                            correct_count = 0;
                            sum=aList.get(correct_count);
                        }
                    }
                    else
                    {
                        sum+=aList.get(correct_count);
                    }
                }
            }
        }
        else if(house10 != null)
        {
            if(score == 0 && new_Question)
            {
                new_Question = false;
                aList = house10.getQuestion();
                if(setTexts())
                {
                    txt_Q_count.setText(house10.get_Q_count());
                    sum=aList.get(correct_count);
                }
            }
            else
            {
                if(score == sum)
                {
                    Q_txt[correct_count].setTextColor(Color.GRAY);
                    Q_txt[correct_count+1].setTextColor(Color.RED);
                    correct_count++;
                    if(correct_count == aList.size())
                    {
                        sound.correct(getContext());
                        reset_all();
                        Q_txt[correct_count-1].setTextColor(Color.GRAY);
                        aList = house10.getQuestion();
                        if(setTexts())
                        {
                            txt_Q_count.setText(house10.get_Q_count());
                            correct_count = 0;
                            sum=aList.get(correct_count);
                        }
                    }
                    else
                    {
                        sum+=aList.get(correct_count);
                    }
                }
            }
        }
        else if(family != null)
        {
            if(score == 0 && new_Question)
            {
                new_Question = false;
                aList = family.getQuestion();
                if(setTexts())
                {
                    txt_Q_count.setText(family.get_Q_count());
                    sum=aList.get(correct_count);
                }
            }
            else
            {
                if(score == sum)
                {
                    Q_txt[correct_count].setTextColor(Color.GRAY);
                    Q_txt[correct_count+1].setTextColor(Color.RED);
                    correct_count++;
                    if(correct_count == aList.size())
                    {
                        sound.correct(getContext());
                        reset_all();
                        Q_txt[correct_count-1].setTextColor(Color.GRAY);
                        aList = family.getQuestion();
                        if(setTexts())
                        {
                            txt_Q_count.setText(family.get_Q_count());
                            correct_count = 0;
                            sum=aList.get(correct_count);
                        }
                    }
                    else
                    {
                        sum+=aList.get(correct_count);
                    }
                }
            }
        }
    }

    public boolean setTexts()
    {
        if(aList.isEmpty())
        {
            Q_txt[0].setText("All are Done Well!");
            Q_txt[1].setText("");
            Q_txt[2].setText("");
            Q_txt[3].setText("");
            Q_txt[4].setText("");
            Q_txt[5].setText("");
            return false;
        }
        else
        {
            Q_txt[0].setTextColor(Color.RED);
            int i;
            for(i=0;i< aList.size();i++)
            {
                if(aList.get(i) > 0)
                {
                    Q_txt[i].setText("+"+aList.get(i));
                }
                else
                {
                    Q_txt[i].setText(aList.get(i)+"");
                }
            }
            for(int j=i;j<6;j++)
            {
                Q_txt[i].setText("");
            }
            Q_txt[0].setTextColor(Color.RED);
            Q_txt[1].setTextColor(Color.GRAY);
            Q_txt[2].setTextColor(Color.GRAY);
            Q_txt[3].setTextColor(Color.GRAY);
            Q_txt[4].setTextColor(Color.GRAY);
            Q_txt[5].setTextColor(Color.GRAY);
            return true;
        }
    }
}