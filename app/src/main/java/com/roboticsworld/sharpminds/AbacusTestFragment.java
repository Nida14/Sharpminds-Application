package com.roboticsworld.sharpminds;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AbacusTestFragment extends Fragment {


    // Class Variables

    // Variables Declaration

    ImageView bd_up_1,bd_up_2,bd_up_3,bd_up_4,im1;
    ImageView bd_dn_1_1,bd_dn_1_2,bd_dn_1_3,bd_dn_1_4;
    ImageView bd_dn_2_1,bd_dn_2_2,bd_dn_2_3,bd_dn_2_4;
    ImageView bd_dn_3_1,bd_dn_3_2,bd_dn_3_3,bd_dn_3_4;
    ImageView bd_dn_4_1,bd_dn_4_2,bd_dn_4_3,bd_dn_4_4;
    ImageView reset;
    int score = 0;
    View view;
    TextView txt_score;
    double pos_top1=0,pos_top2=0,pos_top3=0,pos_top4=0,pos_up=0,def=0;
    boolean is_loaded_axis = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_abacustest, container, false);

        txt_score = view.findViewById(R.id.score);

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

        return view;
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

    public void reset_all()
    {
        load_axis();
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
    }
}