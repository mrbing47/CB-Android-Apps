package garg.sarthik.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static int x, y, x1, y1, x3, y3;
    String TAG = "GAME";
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    int level = 1;
    int[][] a = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    int ctr = 1;
    int sw;
    int p1 = 1;
    int sys = 2;
    int toss = 0;
    int gameSituation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);


        if (toss == 0)
            systemplay();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn1.getText().toString().equals("")) {
                    btn1.setText("X");
                    x = 0;
                    y = 0;
                    a[0][0] = p1;
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }

                    if (gameSituation < 1) {
                        ctr += 2;
                        systemplay();
                    }
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(MainActivity.this, "INVALID MOVE", Toast.LENGTH_SHORT).show();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btn2.getText().toString().equals("")) {
                    btn2.setText("X");
                    x = 1;
                    y = 0;
                    a[0][1] = p1;
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }

                    if (gameSituation < 1) {
                        ctr += 2;
                        systemplay();
                    }
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(MainActivity.this, "INVALID MOVE", Toast.LENGTH_SHORT).show();

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btn3.getText().toString().equals("")) {
                    btn3.setText("X");
                    x = 2;
                    y = 0;
                    a[0][2] = p1;
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }

                    if (gameSituation < 1) {
                        ctr += 2;
                        systemplay();
                    }
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(MainActivity.this, "INVALID MOVE", Toast.LENGTH_SHORT).show();

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btn4.getText().toString().equals("")) {
                    btn4.setText("X");
                    x = 0;
                    y = 1;
                    a[1][0] = p1;
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }

                    if (gameSituation < 1) {
                        ctr += 2;
                        systemplay();
                    }
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(MainActivity.this, "INVALID MOVE", Toast.LENGTH_SHORT).show();

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn5.getText().toString().equals("")) {
                    btn5.setText("X");
                    x = 1;
                    y = 1;
                    a[1][1] = p1;
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }

                    if (gameSituation < 1) {
                        ctr += 2;
                        systemplay();
                    }
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(MainActivity.this, "INVALID MOVE", Toast.LENGTH_SHORT).show();


            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn6.getText().toString().equals("")) {
                    btn6.setText("X");
                    x = 2;
                    y = 1;
                    a[1][2] = p1;
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }

                    if (gameSituation < 1) {
                        ctr += 2;
                        systemplay();
                    }
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(MainActivity.this, "INVALID MOVE", Toast.LENGTH_SHORT).show();


            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn7.getText().toString().equals("")) {
                    btn7.setText("X");
                    x = 0;
                    y = 2;
                    a[2][0] = p1;
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }

                    if (gameSituation < 1) {
                        ctr += 2;
                        systemplay();
                    }
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(MainActivity.this, "INVALID MOVE", Toast.LENGTH_SHORT).show();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btn8.getText().toString().equals("")) {
                    btn8.setText("X");
                    x = 1;
                    y = 2;
                    a[2][1] = p1;
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }

                    if (gameSituation < 1) {
                        ctr += 2;
                        systemplay();
                    }
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(MainActivity.this, "INVALID MOVE", Toast.LENGTH_SHORT).show();

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btn9.getText().toString().equals("")) {
                    btn9.setText("X");
                    x = 2;
                    y = 2;
                    a[2][2] = p1;
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }

                    if (gameSituation < 1) {
                        ctr += 2;
                        systemplay();
                    }
                    gameSituation = gameSituation();
                    if (gameSituation == 2)
                        Toast.makeText(MainActivity.this, "SYSTEM WON!!!", Toast.LENGTH_SHORT).show();
                    else {
                        if (gameSituation == 1)
                            Toast.makeText(MainActivity.this, "PLAYER WOM!!!", Toast.LENGTH_SHORT).show();
                        else if (ctr == 9)
                            Toast.makeText(MainActivity.this, "GAME TIED!!!", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(MainActivity.this, "INVALID MOVE", Toast.LENGTH_SHORT).show();

            }
        });


    }

    void systemplay() {
        Log.e(TAG, "systemplay: SYSTEM_PLAY  " + ctr);
        sw = 0;
        if (!attack()) {
            Log.e(TAG, "systemplay: ATTACK_FAIL");
            if (!defence()) {
                Log.e(TAG, "systemplay: DEFENCE_FAIL");
                if (!strategy()) {
                    Log.e(TAG, "systemplay: STRATEGY_FAIL");
                    boolean rw;
                    do {
                        if (a[y][x] > 0) {
                            x = new Random().nextInt(3);
                            y = new Random().nextInt(3);
                            rw = true;
                        } else {
                            rw = false;
                        }
                    } while (rw);
                }
            }
        }
        Log.e(TAG, "systemplay: x: " + x + " y: " + y);
        sw = y * 3 + x;
        a[y][x] = sys;

        switch (sw) {
            case 0:
                btn1.setText("O");
                break;
            case 1:
                btn2.setText("O");
                break;
            case 2:
                btn3.setText("O");
                break;
            case 3:
                btn4.setText("O");
                break;
            case 4:
                btn5.setText("O");
                break;
            case 5:
                btn6.setText("O");
                break;
            case 6:
                btn7.setText("O");
                break;
            case 7:
                btn8.setText("O");
                break;
            case 8:
                btn9.setText("O");
                break;
        }

    }

    boolean attack() {

        Log.e(TAG, "attack: ");
        for (int k = 0; k < 3; k++) {
            if (a[k][0] == sys && a[k][1] == sys && a[k][2] == 0) {
                x = 2;
                y = k;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[k][1] == sys && a[k][2] == sys && a[k][0] == 0) {
                x = 0;
                y = k;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[k][0] == sys && a[k][2] == sys && a[k][1] == 0) {
                x = 1;
                y = k;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[0][k] == sys && a[1][k] == sys && a[2][k] == 0) {
                x = k;
                y = 2;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[1][k] == sys && a[2][k] == sys && a[0][k] == 0) {
                x = k;
                y = 0;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[2][k] == sys && a[0][k] == sys && a[1][k] == 0) {
                x = k;
                y = 1;
                if (new Random().nextBoolean())
                    return true;
            }

        }
        if (a[y][x] > 0) {
            if (a[2][2] == sys && a[1][1] == sys && a[0][0] == 0) {
                x = 0;
                y = 0;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[0][0] == sys && a[2][2] == sys && a[1][1] == 0) {
                x = 1;
                y = 1;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[0][2] == sys && a[1][1] == sys && a[2][0] == 0) {
                x = 0;
                y = 2;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[2][0] == sys && a[1][1] == sys && a[0][2] == 0) {
                x = 2;
                y = 0;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[2][0] == sys && a[0][2] == sys && a[1][1] == 0) {
                x = 1;
                y = 1;
                if (new Random().nextBoolean())
                    return true;
            }
        }
        if (a[y][x] == 0 && ctr > 1)
            return true;
        else
            return false;
    }

    boolean defence() {

        Log.e(TAG, "defence: ");
        for (int k = 0; k < 3; k++) {
            if (a[k][0] == p1 && a[k][1] == p1 && a[k][2] == 0) {
                x = 2;
                y = k;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[k][1] == p1 && a[k][2] == p1 && a[k][0] == 0) {
                x = 0;
                y = k;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[k][0] == p1 && a[k][2] == p1 && a[k][1] == 0) {
                x = 1;
                y = k;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[0][k] == p1 && a[1][k] == p1 && a[2][k] == 0) {
                x = k;
                y = 2;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[1][k] == p1 && a[2][k] == p1 && a[0][k] == 0) {
                x = k;
                y = 0;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[2][k] == p1 && a[0][k] == p1 && a[1][k] == 0) {
                x = k;
                y = 1;
                if (new Random().nextBoolean())
                    return true;
            }
        }
        if (a[y][x] > 0) {
            if (a[0][0] == p1 && a[1][1] == p1 && a[2][2] == 0) {
                x = 2;
                y = 2;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[2][2] == p1 && a[1][1] == p1 && a[0][0] == 0) {
                x = 0;
                y = 0;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[0][0] == p1 && a[2][2] == p1 && a[1][1] == 0) {
                x = 1;
                y = 1;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[0][2] == p1 && a[1][1] == p1 && a[2][0] == 0) {
                x = 0;
                y = 2;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[2][0] == p1 && a[1][1] == p1 && a[0][2] == 0) {
                x = 2;
                y = 0;
                if (new Random().nextBoolean())
                    return true;
            }
            if (a[2][0] == p1 && a[0][2] == p1 && a[1][1] == 0) {
                x = 1;
                y = 1;
                if (new Random().nextBoolean())
                    return true;
            }
        }
        if (a[y][x] == 0 && ctr > 1)
            return true;
        else
            return false;
    }

    boolean strategy() {

        Log.e(TAG, "strategy: ");

        if (a[y][x] > 0 || ctr == 1)    //a[y][x] shows that if the pointer is at an empty location or already used by Player
        {                            //the second condition is used when the system starts the match so now it can plot some Plans
            if (toss == 0) {
                if (ctr == 1) {
                    x = 1;
                    y = 1;
                } else {
                    if (ctr == 3) {
                        //In this block the system will understand the FIRST move of the player
                        if (y == 1) {
                            y = 2 - x;
                            x = 2 - x;
                        } else {
                            if (x == 1) {
                                y = 2 - y;
                                x = 2 - y;
                            } else {
                                if (x == y) {
                                    x = 2 - x;
                                    y = 2 - y;
                                } else {
                                    y = y + x;
                                    x = y - x;
                                    y = y - x;
                                }
                            }
                            x1 = x;
                            y1 = y;
                        }
                    } else {
                        if (ctr == 5) {
                            //In this block the system will understand the SECOND move of the player
                            if (x == x1) {
                                y = y1;
                                x = 2 - x1;
                            } else {
                                if (y == y1) {
                                    y = 2 - y1;
                                    x = x1;
                                }
                            }
                        }
                    }
                }
            } else {
                if (ctr == 2) {
                    //This checks if the centre of the table is empty or not
                    if (a[1][1] == 0) {
                        x = x1 = 1;
                        y = y1 = 1;
                    }
                    //If not, then it will place the element at the top left postion
                    else {
                        x = x1 = 0;
                        y = y1 = 0;
                    }
                } else {
                    if (ctr == 4) {
                        if (x1 == 0 && y1 == 0) {
                            x = 2;
                            y = 0;

                        } else {
                            if ((x == y3 && y == x3) || (x3 == y3 && x == y)) {

                                if (y > y3) {
                                    y--;
                                } else {
                                    y = y3 - 1;
                                }
                                x = x;
                            }
                        }
                    }
                }
                if (a[y][x] == 1) {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            for (int k = 0; k < 3; k++) {
                                //for (int h = 0; h < 3; h++)
                                {
                                    if (k == 0) {
                                        //if (h == 0)
                                        {
                                            if (a[k][j] == p1 && a[i][0] == p1 && a[i][j] == 0 && a[i][1] == 0 && a[i][2] == 0 && a[1][j] == 0 && a[2][j] == 0) {
                                                x = j;
                                                y = i;
                                                sw = 1;
                                            }
                                        }
                                        //if (h == 1)
                                        {
                                            if (a[k][j] == p1 && a[i][1] == p1 && a[i][j] == 0 && a[i][0] == 0 && a[i][2] == 0 && a[1][j] == 0 && a[2][j] == 0) {
                                                x = j;
                                                y = i;
                                                sw = 1;
                                            }
                                        }
                                        //if (h == 2)
                                        {
                                            if (a[k][j] == p1 && a[i][2] == p1 && a[i][j] == 0 && a[i][1] == 0 && a[i][0] == 0 && a[1][j] == 0 && a[2][j] == 0) {
                                                x = j;
                                                y = i;
                                                sw = 1;
                                            }
                                        }
                                    }
                                    if (k == 1) {
                                        //if (h == 0)
                                        {
                                            if (a[k][j] == p1 && a[i][0] == p1 && a[i][j] == 0 && a[i][1] == 0 && a[i][2] == 0 && a[0][j] == 0 && a[2][j] == 0) {
                                                x = j;
                                                y = i;
                                                sw = 1;
                                            }
                                        }
                                        //if (h == 1)
                                        {
                                            if (a[k][j] == p1 && a[i][1] == p1 && a[i][j] == 0 && a[i][0] == 0 && a[i][2] == 0 && a[0][j] == 0 && a[2][j] == 0) {
                                                x = j;
                                                y = i;
                                                sw = 1;
                                            }
                                        }
                                        //if (h == 2)
                                        {
                                            if (a[k][j] == p1 && a[i][2] == p1 && a[i][j] == 0 && a[i][1] == 0 && a[i][0] == 0 && a[0][j] == 0 && a[2][j] == 0) {
                                                x = j;
                                                y = i;
                                                sw = 1;
                                            }
                                        }
                                    }
                                    if (k == 2) {
                                        //if (h == 0)
                                        {
                                            if (a[k][j] == p1 && a[i][0] == p1 && a[i][j] == 0 && a[i][1] == 0 && a[i][2] == 0 && a[1][j] == 0 && a[0][j] == 0) {
                                                x = j;
                                                y = i;
                                                sw = 1;
                                            }
                                        }
                                        //if (h == 1)
                                        {
                                            if (a[k][j] == p1 && a[i][1] == p1 && a[i][j] == 0 && a[i][0] == 0 && a[i][2] == 0 && a[1][j] == 0 && a[0][j] == 0) {
                                                x = j;
                                                y = i;
                                                sw = 1;
                                            }
                                        }
                                        //if (h == 2)
                                        {
                                            if (a[k][j] == p1 && a[i][2] == p1 && a[i][j] == 0 && a[i][1] == 0 && a[i][0] == 0 && a[1][j] == 0 && a[0][j] == 0) {
                                                x = j;
                                                y = i;
                                                sw = 1;
                                            }
                                        }
                                    }
                                }
                                if (sw == 1)
                                    break;
                            }
                            if (sw == 1)
                                break;
                        }
                        if (sw == 1)
                            break;
                    }
                }
            }
        }
        if (a[y][x] == 0)
            return true;
        else
            return false;
    }

    int gameSituation() {

        int gw = 0;
        for (int i = 0; i < 3; i++) {
            if (a[i][0] == sys && a[i][1] == sys && a[i][2] == sys) {
                gw = 2;
                ctr = 9;
            }
            if (a[0][i] == sys && a[1][i] == sys && a[2][i] == sys) {
                gw = 2;
                ctr = 9;
            }
        }
        if (a[0][0] == sys && a[1][1] == sys && a[2][2] == sys) {
            gw = 2;
            ctr = 9;
        }
        if (a[0][2] == sys && a[1][1] == sys && a[2][0] == sys) {
            gw = 2;
            ctr = 9;
        }
        for (int i = 0; i < 3; i++) {
            if (a[i][0] == p1 && a[i][1] == p1 && a[i][2] == p1) {
                gw = 1;
                ctr = 9;
            }
            if (a[0][i] == p1 && a[1][i] == p1 && a[2][i] == p1) {
                gw = 1;
                ctr = 9;
            }
        }
        if (a[0][0] == p1 && a[1][1] == p1 && a[2][2] == p1) {
            gw = 1;
            ctr = 9;
        }
        if (a[0][2] == p1 && a[1][1] == p1 && a[2][0] == p1) {
            gw = 1;
            ctr = 9;
        }

        return gw;
    }
}
