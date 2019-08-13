lambda1 = sym(4);
lambda2 = sym(6.25);
mu1 = sym(0.45);
mu2 = sym(0.27);
N = 20;
S = 20;
syms x0 x1 x2 x3 x4 x5 x6 x7 x8 x9 x10 x11 x12 x13 x14 x15 x16 x17 x18 x19 x20 x21 x22 x23 x24 x25 x26 x27 x28 x29 x30 x31 x32 x33 x34 x35 x36 x37 x38 x39 x40 x41 x42 x43 x44 x45 x46 x47 x48 x49 x50 x51 x52 x53 x54 x55 x56 x57 x58 x59 x60 x61 x62 x63 x64 x65 x66 x67 x68 x69 x70 x71 x72 x73 x74 x75 x76 x77 x78 x79 x80 x81 x82 x83 x84 x85 x86 x87 x88 x89 x90 x91 x92 x93 x94 x95 x96 x97 x98 x99 x100 x101 x102 x103 x104 x105 x106 x107 x108 x109 x110 x111 x112 x113 x114 x115 x116 x117 x118 x119 x120 x121 x122 x123 x124 x125 x126 x127 x128 x129 x130 x131 x132 x133 x134 x135 x136 x137 x138 x139 x140 x141 x142 x143 x144 x145 x146 x147 x148 x149 x150 x151 x152 x153 x154 x155 x156 x157 x158 x159 x160 x161 x162 x163 x164 x165 x166 x167 x168 x169 x170 x171 x172 x173 x174 x175 x176 x177 x178 x179 x180 x181 x182 x183 x184 x185 x186 x187 x188 x189 x190 x191 x192 x193 x194 x195 x196 x197 x198 x199 x200 x201 x202 x203 x204 x205 x206 x207 x208 x209 x210 x211 x212 x213 x214 x215 x216 x217 x218 x219 x220 x221 x222 x223 x224 x225 x226 x227 x228 x229 x230 x231 
eq1 = (lambda1 + lambda2)*x0 == mu1*x21 + mu2*x1;
eq2 = (lambda1 + lambda2 + mu1*1)*x21 == lambda1*x0 + mu2*x22 + mu1*(1+1)*x41;
eq3 = (lambda1 + lambda2 + mu1*2)*x41 == lambda1*x21 + mu2*x42 + mu1*(2+1)*x60;
eq4 = (lambda1 + lambda2 + mu1*3)*x60 == lambda1*x41 + mu2*x61 + mu1*(3+1)*x78;
eq5 = (lambda1 + lambda2 + mu1*4)*x78 == lambda1*x60 + mu2*x79 + mu1*(4+1)*x95;
eq6 = (lambda1 + lambda2 + mu1*5)*x95 == lambda1*x78 + mu2*x96 + mu1*(5+1)*x111;
eq7 = (lambda1 + lambda2 + mu1*6)*x111 == lambda1*x95 + mu2*x112 + mu1*(6+1)*x126;
eq8 = (lambda1 + lambda2 + mu1*7)*x126 == lambda1*x111 + mu2*x127 + mu1*(7+1)*x140;
eq9 = (lambda1 + lambda2 + mu1*8)*x140 == lambda1*x126 + mu2*x141 + mu1*(8+1)*x153;
eq10 = (lambda1 + lambda2 + mu1*9)*x153 == lambda1*x140 + mu2*x154 + mu1*(9+1)*x165;
eq11 = (lambda1 + lambda2 + mu1*10)*x165 == lambda1*x153 + mu2*x166 + mu1*(10+1)*x176;
eq12 = (lambda1 + lambda2 + mu1*11)*x176 == lambda1*x165 + mu2*x177 + mu1*(11+1)*x186;
eq13 = (lambda1 + lambda2 + mu1*12)*x186 == lambda1*x176 + mu2*x187 + mu1*(12+1)*x195;
eq14 = (lambda1 + lambda2 + mu1*13)*x195 == lambda1*x186 + mu2*x196 + mu1*(13+1)*x203;
eq15 = (lambda1 + lambda2 + mu1*14)*x203 == lambda1*x195 + mu2*x204 + mu1*(14+1)*x210;
eq16 = (lambda1 + lambda2 + mu1*15)*x210 == lambda1*x203 + mu2*x211 + mu1*(15+1)*x216;
eq17 = (lambda1 + lambda2 + mu1*16)*x216 == lambda1*x210 + mu2*x217 + mu1*(16+1)*x221;
eq18 = (lambda1 + lambda2 + mu1*17)*x221 == lambda1*x216 + mu2*x222 + mu1*(17+1)*x225;
eq19 = (lambda1 + lambda2 + mu1*18)*x225 == lambda1*x221 + mu2*x226 + mu1*(18+1)*x228;
eq20 = (lambda1 + lambda2 + mu1*19)*x228 == lambda1*x225 + mu2*x229 + mu1*(19+1)*x230;
eq21 = (lambda1 + lambda2 + mu2*1)*x1 == lambda2*x0 + mu1*x22 + mu2*(1+1)*x2;
eq22 = (lambda1 + lambda2 + mu2*2)*x2 == lambda2*x1 + mu1*x23 + mu2*(2+1)*x3;
eq23 = (lambda1 + lambda2 + mu2*3)*x3 == lambda2*x2 + mu1*x24 + mu2*(3+1)*x4;
eq24 = (lambda1 + lambda2 + mu2*4)*x4 == lambda2*x3 + mu1*x25 + mu2*(4+1)*x5;
eq25 = (lambda1 + lambda2 + mu2*5)*x5 == lambda2*x4 + mu1*x26 + mu2*(5+1)*x6;
eq26 = (lambda1 + lambda2 + mu2*6)*x6 == lambda2*x5 + mu1*x27 + mu2*(6+1)*x7;
eq27 = (lambda1 + lambda2 + mu2*7)*x7 == lambda2*x6 + mu1*x28 + mu2*(7+1)*x8;
eq28 = (lambda1 + lambda2 + mu2*8)*x8 == lambda2*x7 + mu1*x29 + mu2*(8+1)*x9;
eq29 = (lambda1 + lambda2 + mu2*9)*x9 == lambda2*x8 + mu1*x30 + mu2*(9+1)*x10;
eq30 = (lambda1 + lambda2 + mu2*10)*x10 == lambda2*x9 + mu1*x31 + mu2*(10+1)*x11;
eq31 = (lambda1 + lambda2 + mu2*11)*x11 == lambda2*x10 + mu1*x32 + mu2*(11+1)*x12;
eq32 = (lambda1 + lambda2 + mu2*12)*x12 == lambda2*x11 + mu1*x33 + mu2*(12+1)*x13;
eq33 = (lambda1 + lambda2 + mu2*13)*x13 == lambda2*x12 + mu1*x34 + mu2*(13+1)*x14;
eq34 = (lambda1 + lambda2 + mu2*14)*x14 == lambda2*x13 + mu1*x35 + mu2*(14+1)*x15;
eq35 = (lambda1 + lambda2 + mu2*15)*x15 == lambda2*x14 + mu1*x36 + mu2*(15+1)*x16;
eq36 = (lambda1 + lambda2 + mu2*16)*x16 == lambda2*x15 + mu1*x37 + mu2*(16+1)*x17;
eq37 = (lambda1 + lambda2 + mu2*17)*x17 == lambda2*x16 + mu1*x38 + mu2*(17+1)*x18;
eq38 = (lambda1 + lambda2 + mu2*18)*x18 == lambda2*x17 + mu1*x39 + mu2*(18+1)*x19;
eq39 = (lambda1 + lambda2 + mu2*19)*x19 == lambda2*x18 + mu1*x40 + mu2*(19+1)*x20;
eq40 = (S*mu1)*x230 == lambda1*x228 + lambda1*x229;
eq41 = (S*mu2 + lambda1)*x20 == lambda2*x19;
eq42 = (mu1*1 + mu2*19 + lambda1)*x40 == lambda1*x20 + lambda1*x19 + lambda2*x39;
eq43 = (mu1*2 + mu2*18 + lambda1)*x59 == lambda1*x40 + lambda1*x39 + lambda2*x58;
eq44 = (mu1*3 + mu2*17 + lambda1)*x77 == lambda1*x59 + lambda1*x58 + lambda2*x76;
eq45 = (mu1*4 + mu2*16 + lambda1)*x94 == lambda1*x77 + lambda1*x76 + lambda2*x93;
eq46 = (mu1*5 + mu2*15 + lambda1)*x110 == lambda1*x94 + lambda1*x93 + lambda2*x109;
eq47 = (mu1*6 + mu2*14 + lambda1)*x125 == lambda1*x110 + lambda1*x109 + lambda2*x124;
eq48 = (mu1*7 + mu2*13 + lambda1)*x139 == lambda1*x125 + lambda1*x124 + lambda2*x138;
eq49 = (mu1*8 + mu2*12 + lambda1)*x152 == lambda1*x139 + lambda1*x138 + lambda2*x151;
eq50 = (mu1*9 + mu2*11 + lambda1)*x164 == lambda1*x152 + lambda1*x151 + lambda2*x163;
eq51 = (mu1*10 + mu2*10 + lambda1)*x175 == lambda1*x164 + lambda1*x163 + lambda2*x174;
eq52 = (mu1*11 + mu2*9 + lambda1)*x185 == lambda1*x175 + lambda1*x174 + lambda2*x184;
eq53 = (mu1*12 + mu2*8 + lambda1)*x194 == lambda1*x185 + lambda1*x184 + lambda2*x193;
eq54 = (mu1*13 + mu2*7 + lambda1)*x202 == lambda1*x194 + lambda1*x193 + lambda2*x201;
eq55 = (mu1*14 + mu2*6 + lambda1)*x209 == lambda1*x202 + lambda1*x201 + lambda2*x208;
eq56 = (mu1*15 + mu2*5 + lambda1)*x215 == lambda1*x209 + lambda1*x208 + lambda2*x214;
eq57 = (mu1*16 + mu2*4 + lambda1)*x220 == lambda1*x215 + lambda1*x214 + lambda2*x219;
eq58 = (mu1*17 + mu2*3 + lambda1)*x224 == lambda1*x220 + lambda1*x219 + lambda2*x223;
eq59 = (mu1*18 + mu2*2 + lambda1)*x227 == lambda1*x224 + lambda1*x223 + lambda2*x226;
eq60 = (mu1*19 + mu2*1 + lambda1)*x229 == lambda1*x227 + lambda1*x226 + lambda2*x228;
eq61 = (lambda1 + lambda2 + mu1*1 + mu2*1)*x22 == lambda1*x1 + lambda2*x21 + mu1*(1 + 1)*x42 + mu2*(1+1)*x23;
eq62 = (lambda1 + lambda2 + mu1*1 + mu2*2)*x23 == lambda1*x2 + lambda2*x22 + mu1*(1 + 1)*x43 + mu2*(2+1)*x24;
eq63 = (lambda1 + lambda2 + mu1*1 + mu2*3)*x24 == lambda1*x3 + lambda2*x23 + mu1*(1 + 1)*x44 + mu2*(3+1)*x25;
eq64 = (lambda1 + lambda2 + mu1*1 + mu2*4)*x25 == lambda1*x4 + lambda2*x24 + mu1*(1 + 1)*x45 + mu2*(4+1)*x26;
eq65 = (lambda1 + lambda2 + mu1*1 + mu2*5)*x26 == lambda1*x5 + lambda2*x25 + mu1*(1 + 1)*x46 + mu2*(5+1)*x27;
eq66 = (lambda1 + lambda2 + mu1*1 + mu2*6)*x27 == lambda1*x6 + lambda2*x26 + mu1*(1 + 1)*x47 + mu2*(6+1)*x28;
eq67 = (lambda1 + lambda2 + mu1*1 + mu2*7)*x28 == lambda1*x7 + lambda2*x27 + mu1*(1 + 1)*x48 + mu2*(7+1)*x29;
eq68 = (lambda1 + lambda2 + mu1*1 + mu2*8)*x29 == lambda1*x8 + lambda2*x28 + mu1*(1 + 1)*x49 + mu2*(8+1)*x30;
eq69 = (lambda1 + lambda2 + mu1*1 + mu2*9)*x30 == lambda1*x9 + lambda2*x29 + mu1*(1 + 1)*x50 + mu2*(9+1)*x31;
eq70 = (lambda1 + lambda2 + mu1*1 + mu2*10)*x31 == lambda1*x10 + lambda2*x30 + mu1*(1 + 1)*x51 + mu2*(10+1)*x32;
eq71 = (lambda1 + lambda2 + mu1*1 + mu2*11)*x32 == lambda1*x11 + lambda2*x31 + mu1*(1 + 1)*x52 + mu2*(11+1)*x33;
eq72 = (lambda1 + lambda2 + mu1*1 + mu2*12)*x33 == lambda1*x12 + lambda2*x32 + mu1*(1 + 1)*x53 + mu2*(12+1)*x34;
eq73 = (lambda1 + lambda2 + mu1*1 + mu2*13)*x34 == lambda1*x13 + lambda2*x33 + mu1*(1 + 1)*x54 + mu2*(13+1)*x35;
eq74 = (lambda1 + lambda2 + mu1*1 + mu2*14)*x35 == lambda1*x14 + lambda2*x34 + mu1*(1 + 1)*x55 + mu2*(14+1)*x36;
eq75 = (lambda1 + lambda2 + mu1*1 + mu2*15)*x36 == lambda1*x15 + lambda2*x35 + mu1*(1 + 1)*x56 + mu2*(15+1)*x37;
eq76 = (lambda1 + lambda2 + mu1*1 + mu2*16)*x37 == lambda1*x16 + lambda2*x36 + mu1*(1 + 1)*x57 + mu2*(16+1)*x38;
eq77 = (lambda1 + lambda2 + mu1*1 + mu2*17)*x38 == lambda1*x17 + lambda2*x37 + mu1*(1 + 1)*x58 + mu2*(17+1)*x39;
eq78 = (lambda1 + lambda2 + mu1*1 + mu2*18)*x39 == lambda1*x18 + lambda2*x38 + mu1*(1 + 1)*x59 + mu2*(18+1)*x40;
eq79 = (lambda1 + lambda2 + mu1*2 + mu2*1)*x42 == lambda1*x22 + lambda2*x41 + mu1*(2 + 1)*x61 + mu2*(1+1)*x43;
eq80 = (lambda1 + lambda2 + mu1*2 + mu2*2)*x43 == lambda1*x23 + lambda2*x42 + mu1*(2 + 1)*x62 + mu2*(2+1)*x44;
eq81 = (lambda1 + lambda2 + mu1*2 + mu2*3)*x44 == lambda1*x24 + lambda2*x43 + mu1*(2 + 1)*x63 + mu2*(3+1)*x45;
eq82 = (lambda1 + lambda2 + mu1*2 + mu2*4)*x45 == lambda1*x25 + lambda2*x44 + mu1*(2 + 1)*x64 + mu2*(4+1)*x46;
eq83 = (lambda1 + lambda2 + mu1*2 + mu2*5)*x46 == lambda1*x26 + lambda2*x45 + mu1*(2 + 1)*x65 + mu2*(5+1)*x47;
eq84 = (lambda1 + lambda2 + mu1*2 + mu2*6)*x47 == lambda1*x27 + lambda2*x46 + mu1*(2 + 1)*x66 + mu2*(6+1)*x48;
eq85 = (lambda1 + lambda2 + mu1*2 + mu2*7)*x48 == lambda1*x28 + lambda2*x47 + mu1*(2 + 1)*x67 + mu2*(7+1)*x49;
eq86 = (lambda1 + lambda2 + mu1*2 + mu2*8)*x49 == lambda1*x29 + lambda2*x48 + mu1*(2 + 1)*x68 + mu2*(8+1)*x50;
eq87 = (lambda1 + lambda2 + mu1*2 + mu2*9)*x50 == lambda1*x30 + lambda2*x49 + mu1*(2 + 1)*x69 + mu2*(9+1)*x51;
eq88 = (lambda1 + lambda2 + mu1*2 + mu2*10)*x51 == lambda1*x31 + lambda2*x50 + mu1*(2 + 1)*x70 + mu2*(10+1)*x52;
eq89 = (lambda1 + lambda2 + mu1*2 + mu2*11)*x52 == lambda1*x32 + lambda2*x51 + mu1*(2 + 1)*x71 + mu2*(11+1)*x53;
eq90 = (lambda1 + lambda2 + mu1*2 + mu2*12)*x53 == lambda1*x33 + lambda2*x52 + mu1*(2 + 1)*x72 + mu2*(12+1)*x54;
eq91 = (lambda1 + lambda2 + mu1*2 + mu2*13)*x54 == lambda1*x34 + lambda2*x53 + mu1*(2 + 1)*x73 + mu2*(13+1)*x55;
eq92 = (lambda1 + lambda2 + mu1*2 + mu2*14)*x55 == lambda1*x35 + lambda2*x54 + mu1*(2 + 1)*x74 + mu2*(14+1)*x56;
eq93 = (lambda1 + lambda2 + mu1*2 + mu2*15)*x56 == lambda1*x36 + lambda2*x55 + mu1*(2 + 1)*x75 + mu2*(15+1)*x57;
eq94 = (lambda1 + lambda2 + mu1*2 + mu2*16)*x57 == lambda1*x37 + lambda2*x56 + mu1*(2 + 1)*x76 + mu2*(16+1)*x58;
eq95 = (lambda1 + lambda2 + mu1*2 + mu2*17)*x58 == lambda1*x38 + lambda2*x57 + mu1*(2 + 1)*x77 + mu2*(17+1)*x59;
eq96 = (lambda1 + lambda2 + mu1*3 + mu2*1)*x61 == lambda1*x42 + lambda2*x60 + mu1*(3 + 1)*x79 + mu2*(1+1)*x62;
eq97 = (lambda1 + lambda2 + mu1*3 + mu2*2)*x62 == lambda1*x43 + lambda2*x61 + mu1*(3 + 1)*x80 + mu2*(2+1)*x63;
eq98 = (lambda1 + lambda2 + mu1*3 + mu2*3)*x63 == lambda1*x44 + lambda2*x62 + mu1*(3 + 1)*x81 + mu2*(3+1)*x64;
eq99 = (lambda1 + lambda2 + mu1*3 + mu2*4)*x64 == lambda1*x45 + lambda2*x63 + mu1*(3 + 1)*x82 + mu2*(4+1)*x65;
eq100 = (lambda1 + lambda2 + mu1*3 + mu2*5)*x65 == lambda1*x46 + lambda2*x64 + mu1*(3 + 1)*x83 + mu2*(5+1)*x66;
eq101 = (lambda1 + lambda2 + mu1*3 + mu2*6)*x66 == lambda1*x47 + lambda2*x65 + mu1*(3 + 1)*x84 + mu2*(6+1)*x67;
eq102 = (lambda1 + lambda2 + mu1*3 + mu2*7)*x67 == lambda1*x48 + lambda2*x66 + mu1*(3 + 1)*x85 + mu2*(7+1)*x68;
eq103 = (lambda1 + lambda2 + mu1*3 + mu2*8)*x68 == lambda1*x49 + lambda2*x67 + mu1*(3 + 1)*x86 + mu2*(8+1)*x69;
eq104 = (lambda1 + lambda2 + mu1*3 + mu2*9)*x69 == lambda1*x50 + lambda2*x68 + mu1*(3 + 1)*x87 + mu2*(9+1)*x70;
eq105 = (lambda1 + lambda2 + mu1*3 + mu2*10)*x70 == lambda1*x51 + lambda2*x69 + mu1*(3 + 1)*x88 + mu2*(10+1)*x71;
eq106 = (lambda1 + lambda2 + mu1*3 + mu2*11)*x71 == lambda1*x52 + lambda2*x70 + mu1*(3 + 1)*x89 + mu2*(11+1)*x72;
eq107 = (lambda1 + lambda2 + mu1*3 + mu2*12)*x72 == lambda1*x53 + lambda2*x71 + mu1*(3 + 1)*x90 + mu2*(12+1)*x73;
eq108 = (lambda1 + lambda2 + mu1*3 + mu2*13)*x73 == lambda1*x54 + lambda2*x72 + mu1*(3 + 1)*x91 + mu2*(13+1)*x74;
eq109 = (lambda1 + lambda2 + mu1*3 + mu2*14)*x74 == lambda1*x55 + lambda2*x73 + mu1*(3 + 1)*x92 + mu2*(14+1)*x75;
eq110 = (lambda1 + lambda2 + mu1*3 + mu2*15)*x75 == lambda1*x56 + lambda2*x74 + mu1*(3 + 1)*x93 + mu2*(15+1)*x76;
eq111 = (lambda1 + lambda2 + mu1*3 + mu2*16)*x76 == lambda1*x57 + lambda2*x75 + mu1*(3 + 1)*x94 + mu2*(16+1)*x77;
eq112 = (lambda1 + lambda2 + mu1*4 + mu2*1)*x79 == lambda1*x61 + lambda2*x78 + mu1*(4 + 1)*x96 + mu2*(1+1)*x80;
eq113 = (lambda1 + lambda2 + mu1*4 + mu2*2)*x80 == lambda1*x62 + lambda2*x79 + mu1*(4 + 1)*x97 + mu2*(2+1)*x81;
eq114 = (lambda1 + lambda2 + mu1*4 + mu2*3)*x81 == lambda1*x63 + lambda2*x80 + mu1*(4 + 1)*x98 + mu2*(3+1)*x82;
eq115 = (lambda1 + lambda2 + mu1*4 + mu2*4)*x82 == lambda1*x64 + lambda2*x81 + mu1*(4 + 1)*x99 + mu2*(4+1)*x83;
eq116 = (lambda1 + lambda2 + mu1*4 + mu2*5)*x83 == lambda1*x65 + lambda2*x82 + mu1*(4 + 1)*x100 + mu2*(5+1)*x84;
eq117 = (lambda1 + lambda2 + mu1*4 + mu2*6)*x84 == lambda1*x66 + lambda2*x83 + mu1*(4 + 1)*x101 + mu2*(6+1)*x85;
eq118 = (lambda1 + lambda2 + mu1*4 + mu2*7)*x85 == lambda1*x67 + lambda2*x84 + mu1*(4 + 1)*x102 + mu2*(7+1)*x86;
eq119 = (lambda1 + lambda2 + mu1*4 + mu2*8)*x86 == lambda1*x68 + lambda2*x85 + mu1*(4 + 1)*x103 + mu2*(8+1)*x87;
eq120 = (lambda1 + lambda2 + mu1*4 + mu2*9)*x87 == lambda1*x69 + lambda2*x86 + mu1*(4 + 1)*x104 + mu2*(9+1)*x88;
eq121 = (lambda1 + lambda2 + mu1*4 + mu2*10)*x88 == lambda1*x70 + lambda2*x87 + mu1*(4 + 1)*x105 + mu2*(10+1)*x89;
eq122 = (lambda1 + lambda2 + mu1*4 + mu2*11)*x89 == lambda1*x71 + lambda2*x88 + mu1*(4 + 1)*x106 + mu2*(11+1)*x90;
eq123 = (lambda1 + lambda2 + mu1*4 + mu2*12)*x90 == lambda1*x72 + lambda2*x89 + mu1*(4 + 1)*x107 + mu2*(12+1)*x91;
eq124 = (lambda1 + lambda2 + mu1*4 + mu2*13)*x91 == lambda1*x73 + lambda2*x90 + mu1*(4 + 1)*x108 + mu2*(13+1)*x92;
eq125 = (lambda1 + lambda2 + mu1*4 + mu2*14)*x92 == lambda1*x74 + lambda2*x91 + mu1*(4 + 1)*x109 + mu2*(14+1)*x93;
eq126 = (lambda1 + lambda2 + mu1*4 + mu2*15)*x93 == lambda1*x75 + lambda2*x92 + mu1*(4 + 1)*x110 + mu2*(15+1)*x94;
eq127 = (lambda1 + lambda2 + mu1*5 + mu2*1)*x96 == lambda1*x79 + lambda2*x95 + mu1*(5 + 1)*x112 + mu2*(1+1)*x97;
eq128 = (lambda1 + lambda2 + mu1*5 + mu2*2)*x97 == lambda1*x80 + lambda2*x96 + mu1*(5 + 1)*x113 + mu2*(2+1)*x98;
eq129 = (lambda1 + lambda2 + mu1*5 + mu2*3)*x98 == lambda1*x81 + lambda2*x97 + mu1*(5 + 1)*x114 + mu2*(3+1)*x99;
eq130 = (lambda1 + lambda2 + mu1*5 + mu2*4)*x99 == lambda1*x82 + lambda2*x98 + mu1*(5 + 1)*x115 + mu2*(4+1)*x100;
eq131 = (lambda1 + lambda2 + mu1*5 + mu2*5)*x100 == lambda1*x83 + lambda2*x99 + mu1*(5 + 1)*x116 + mu2*(5+1)*x101;
eq132 = (lambda1 + lambda2 + mu1*5 + mu2*6)*x101 == lambda1*x84 + lambda2*x100 + mu1*(5 + 1)*x117 + mu2*(6+1)*x102;
eq133 = (lambda1 + lambda2 + mu1*5 + mu2*7)*x102 == lambda1*x85 + lambda2*x101 + mu1*(5 + 1)*x118 + mu2*(7+1)*x103;
eq134 = (lambda1 + lambda2 + mu1*5 + mu2*8)*x103 == lambda1*x86 + lambda2*x102 + mu1*(5 + 1)*x119 + mu2*(8+1)*x104;
eq135 = (lambda1 + lambda2 + mu1*5 + mu2*9)*x104 == lambda1*x87 + lambda2*x103 + mu1*(5 + 1)*x120 + mu2*(9+1)*x105;
eq136 = (lambda1 + lambda2 + mu1*5 + mu2*10)*x105 == lambda1*x88 + lambda2*x104 + mu1*(5 + 1)*x121 + mu2*(10+1)*x106;
eq137 = (lambda1 + lambda2 + mu1*5 + mu2*11)*x106 == lambda1*x89 + lambda2*x105 + mu1*(5 + 1)*x122 + mu2*(11+1)*x107;
eq138 = (lambda1 + lambda2 + mu1*5 + mu2*12)*x107 == lambda1*x90 + lambda2*x106 + mu1*(5 + 1)*x123 + mu2*(12+1)*x108;
eq139 = (lambda1 + lambda2 + mu1*5 + mu2*13)*x108 == lambda1*x91 + lambda2*x107 + mu1*(5 + 1)*x124 + mu2*(13+1)*x109;
eq140 = (lambda1 + lambda2 + mu1*5 + mu2*14)*x109 == lambda1*x92 + lambda2*x108 + mu1*(5 + 1)*x125 + mu2*(14+1)*x110;
eq141 = (lambda1 + lambda2 + mu1*6 + mu2*1)*x112 == lambda1*x96 + lambda2*x111 + mu1*(6 + 1)*x127 + mu2*(1+1)*x113;
eq142 = (lambda1 + lambda2 + mu1*6 + mu2*2)*x113 == lambda1*x97 + lambda2*x112 + mu1*(6 + 1)*x128 + mu2*(2+1)*x114;
eq143 = (lambda1 + lambda2 + mu1*6 + mu2*3)*x114 == lambda1*x98 + lambda2*x113 + mu1*(6 + 1)*x129 + mu2*(3+1)*x115;
eq144 = (lambda1 + lambda2 + mu1*6 + mu2*4)*x115 == lambda1*x99 + lambda2*x114 + mu1*(6 + 1)*x130 + mu2*(4+1)*x116;
eq145 = (lambda1 + lambda2 + mu1*6 + mu2*5)*x116 == lambda1*x100 + lambda2*x115 + mu1*(6 + 1)*x131 + mu2*(5+1)*x117;
eq146 = (lambda1 + lambda2 + mu1*6 + mu2*6)*x117 == lambda1*x101 + lambda2*x116 + mu1*(6 + 1)*x132 + mu2*(6+1)*x118;
eq147 = (lambda1 + lambda2 + mu1*6 + mu2*7)*x118 == lambda1*x102 + lambda2*x117 + mu1*(6 + 1)*x133 + mu2*(7+1)*x119;
eq148 = (lambda1 + lambda2 + mu1*6 + mu2*8)*x119 == lambda1*x103 + lambda2*x118 + mu1*(6 + 1)*x134 + mu2*(8+1)*x120;
eq149 = (lambda1 + lambda2 + mu1*6 + mu2*9)*x120 == lambda1*x104 + lambda2*x119 + mu1*(6 + 1)*x135 + mu2*(9+1)*x121;
eq150 = (lambda1 + lambda2 + mu1*6 + mu2*10)*x121 == lambda1*x105 + lambda2*x120 + mu1*(6 + 1)*x136 + mu2*(10+1)*x122;
eq151 = (lambda1 + lambda2 + mu1*6 + mu2*11)*x122 == lambda1*x106 + lambda2*x121 + mu1*(6 + 1)*x137 + mu2*(11+1)*x123;
eq152 = (lambda1 + lambda2 + mu1*6 + mu2*12)*x123 == lambda1*x107 + lambda2*x122 + mu1*(6 + 1)*x138 + mu2*(12+1)*x124;
eq153 = (lambda1 + lambda2 + mu1*6 + mu2*13)*x124 == lambda1*x108 + lambda2*x123 + mu1*(6 + 1)*x139 + mu2*(13+1)*x125;
eq154 = (lambda1 + lambda2 + mu1*7 + mu2*1)*x127 == lambda1*x112 + lambda2*x126 + mu1*(7 + 1)*x141 + mu2*(1+1)*x128;
eq155 = (lambda1 + lambda2 + mu1*7 + mu2*2)*x128 == lambda1*x113 + lambda2*x127 + mu1*(7 + 1)*x142 + mu2*(2+1)*x129;
eq156 = (lambda1 + lambda2 + mu1*7 + mu2*3)*x129 == lambda1*x114 + lambda2*x128 + mu1*(7 + 1)*x143 + mu2*(3+1)*x130;
eq157 = (lambda1 + lambda2 + mu1*7 + mu2*4)*x130 == lambda1*x115 + lambda2*x129 + mu1*(7 + 1)*x144 + mu2*(4+1)*x131;
eq158 = (lambda1 + lambda2 + mu1*7 + mu2*5)*x131 == lambda1*x116 + lambda2*x130 + mu1*(7 + 1)*x145 + mu2*(5+1)*x132;
eq159 = (lambda1 + lambda2 + mu1*7 + mu2*6)*x132 == lambda1*x117 + lambda2*x131 + mu1*(7 + 1)*x146 + mu2*(6+1)*x133;
eq160 = (lambda1 + lambda2 + mu1*7 + mu2*7)*x133 == lambda1*x118 + lambda2*x132 + mu1*(7 + 1)*x147 + mu2*(7+1)*x134;
eq161 = (lambda1 + lambda2 + mu1*7 + mu2*8)*x134 == lambda1*x119 + lambda2*x133 + mu1*(7 + 1)*x148 + mu2*(8+1)*x135;
eq162 = (lambda1 + lambda2 + mu1*7 + mu2*9)*x135 == lambda1*x120 + lambda2*x134 + mu1*(7 + 1)*x149 + mu2*(9+1)*x136;
eq163 = (lambda1 + lambda2 + mu1*7 + mu2*10)*x136 == lambda1*x121 + lambda2*x135 + mu1*(7 + 1)*x150 + mu2*(10+1)*x137;
eq164 = (lambda1 + lambda2 + mu1*7 + mu2*11)*x137 == lambda1*x122 + lambda2*x136 + mu1*(7 + 1)*x151 + mu2*(11+1)*x138;
eq165 = (lambda1 + lambda2 + mu1*7 + mu2*12)*x138 == lambda1*x123 + lambda2*x137 + mu1*(7 + 1)*x152 + mu2*(12+1)*x139;
eq166 = (lambda1 + lambda2 + mu1*8 + mu2*1)*x141 == lambda1*x127 + lambda2*x140 + mu1*(8 + 1)*x154 + mu2*(1+1)*x142;
eq167 = (lambda1 + lambda2 + mu1*8 + mu2*2)*x142 == lambda1*x128 + lambda2*x141 + mu1*(8 + 1)*x155 + mu2*(2+1)*x143;
eq168 = (lambda1 + lambda2 + mu1*8 + mu2*3)*x143 == lambda1*x129 + lambda2*x142 + mu1*(8 + 1)*x156 + mu2*(3+1)*x144;
eq169 = (lambda1 + lambda2 + mu1*8 + mu2*4)*x144 == lambda1*x130 + lambda2*x143 + mu1*(8 + 1)*x157 + mu2*(4+1)*x145;
eq170 = (lambda1 + lambda2 + mu1*8 + mu2*5)*x145 == lambda1*x131 + lambda2*x144 + mu1*(8 + 1)*x158 + mu2*(5+1)*x146;
eq171 = (lambda1 + lambda2 + mu1*8 + mu2*6)*x146 == lambda1*x132 + lambda2*x145 + mu1*(8 + 1)*x159 + mu2*(6+1)*x147;
eq172 = (lambda1 + lambda2 + mu1*8 + mu2*7)*x147 == lambda1*x133 + lambda2*x146 + mu1*(8 + 1)*x160 + mu2*(7+1)*x148;
eq173 = (lambda1 + lambda2 + mu1*8 + mu2*8)*x148 == lambda1*x134 + lambda2*x147 + mu1*(8 + 1)*x161 + mu2*(8+1)*x149;
eq174 = (lambda1 + lambda2 + mu1*8 + mu2*9)*x149 == lambda1*x135 + lambda2*x148 + mu1*(8 + 1)*x162 + mu2*(9+1)*x150;
eq175 = (lambda1 + lambda2 + mu1*8 + mu2*10)*x150 == lambda1*x136 + lambda2*x149 + mu1*(8 + 1)*x163 + mu2*(10+1)*x151;
eq176 = (lambda1 + lambda2 + mu1*8 + mu2*11)*x151 == lambda1*x137 + lambda2*x150 + mu1*(8 + 1)*x164 + mu2*(11+1)*x152;
eq177 = (lambda1 + lambda2 + mu1*9 + mu2*1)*x154 == lambda1*x141 + lambda2*x153 + mu1*(9 + 1)*x166 + mu2*(1+1)*x155;
eq178 = (lambda1 + lambda2 + mu1*9 + mu2*2)*x155 == lambda1*x142 + lambda2*x154 + mu1*(9 + 1)*x167 + mu2*(2+1)*x156;
eq179 = (lambda1 + lambda2 + mu1*9 + mu2*3)*x156 == lambda1*x143 + lambda2*x155 + mu1*(9 + 1)*x168 + mu2*(3+1)*x157;
eq180 = (lambda1 + lambda2 + mu1*9 + mu2*4)*x157 == lambda1*x144 + lambda2*x156 + mu1*(9 + 1)*x169 + mu2*(4+1)*x158;
eq181 = (lambda1 + lambda2 + mu1*9 + mu2*5)*x158 == lambda1*x145 + lambda2*x157 + mu1*(9 + 1)*x170 + mu2*(5+1)*x159;
eq182 = (lambda1 + lambda2 + mu1*9 + mu2*6)*x159 == lambda1*x146 + lambda2*x158 + mu1*(9 + 1)*x171 + mu2*(6+1)*x160;
eq183 = (lambda1 + lambda2 + mu1*9 + mu2*7)*x160 == lambda1*x147 + lambda2*x159 + mu1*(9 + 1)*x172 + mu2*(7+1)*x161;
eq184 = (lambda1 + lambda2 + mu1*9 + mu2*8)*x161 == lambda1*x148 + lambda2*x160 + mu1*(9 + 1)*x173 + mu2*(8+1)*x162;
eq185 = (lambda1 + lambda2 + mu1*9 + mu2*9)*x162 == lambda1*x149 + lambda2*x161 + mu1*(9 + 1)*x174 + mu2*(9+1)*x163;
eq186 = (lambda1 + lambda2 + mu1*9 + mu2*10)*x163 == lambda1*x150 + lambda2*x162 + mu1*(9 + 1)*x175 + mu2*(10+1)*x164;
eq187 = (lambda1 + lambda2 + mu1*10 + mu2*1)*x166 == lambda1*x154 + lambda2*x165 + mu1*(10 + 1)*x177 + mu2*(1+1)*x167;
eq188 = (lambda1 + lambda2 + mu1*10 + mu2*2)*x167 == lambda1*x155 + lambda2*x166 + mu1*(10 + 1)*x178 + mu2*(2+1)*x168;
eq189 = (lambda1 + lambda2 + mu1*10 + mu2*3)*x168 == lambda1*x156 + lambda2*x167 + mu1*(10 + 1)*x179 + mu2*(3+1)*x169;
eq190 = (lambda1 + lambda2 + mu1*10 + mu2*4)*x169 == lambda1*x157 + lambda2*x168 + mu1*(10 + 1)*x180 + mu2*(4+1)*x170;
eq191 = (lambda1 + lambda2 + mu1*10 + mu2*5)*x170 == lambda1*x158 + lambda2*x169 + mu1*(10 + 1)*x181 + mu2*(5+1)*x171;
eq192 = (lambda1 + lambda2 + mu1*10 + mu2*6)*x171 == lambda1*x159 + lambda2*x170 + mu1*(10 + 1)*x182 + mu2*(6+1)*x172;
eq193 = (lambda1 + lambda2 + mu1*10 + mu2*7)*x172 == lambda1*x160 + lambda2*x171 + mu1*(10 + 1)*x183 + mu2*(7+1)*x173;
eq194 = (lambda1 + lambda2 + mu1*10 + mu2*8)*x173 == lambda1*x161 + lambda2*x172 + mu1*(10 + 1)*x184 + mu2*(8+1)*x174;
eq195 = (lambda1 + lambda2 + mu1*10 + mu2*9)*x174 == lambda1*x162 + lambda2*x173 + mu1*(10 + 1)*x185 + mu2*(9+1)*x175;
eq196 = (lambda1 + lambda2 + mu1*11 + mu2*1)*x177 == lambda1*x166 + lambda2*x176 + mu1*(11 + 1)*x187 + mu2*(1+1)*x178;
eq197 = (lambda1 + lambda2 + mu1*11 + mu2*2)*x178 == lambda1*x167 + lambda2*x177 + mu1*(11 + 1)*x188 + mu2*(2+1)*x179;
eq198 = (lambda1 + lambda2 + mu1*11 + mu2*3)*x179 == lambda1*x168 + lambda2*x178 + mu1*(11 + 1)*x189 + mu2*(3+1)*x180;
eq199 = (lambda1 + lambda2 + mu1*11 + mu2*4)*x180 == lambda1*x169 + lambda2*x179 + mu1*(11 + 1)*x190 + mu2*(4+1)*x181;
eq200 = (lambda1 + lambda2 + mu1*11 + mu2*5)*x181 == lambda1*x170 + lambda2*x180 + mu1*(11 + 1)*x191 + mu2*(5+1)*x182;
eq201 = (lambda1 + lambda2 + mu1*11 + mu2*6)*x182 == lambda1*x171 + lambda2*x181 + mu1*(11 + 1)*x192 + mu2*(6+1)*x183;
eq202 = (lambda1 + lambda2 + mu1*11 + mu2*7)*x183 == lambda1*x172 + lambda2*x182 + mu1*(11 + 1)*x193 + mu2*(7+1)*x184;
eq203 = (lambda1 + lambda2 + mu1*11 + mu2*8)*x184 == lambda1*x173 + lambda2*x183 + mu1*(11 + 1)*x194 + mu2*(8+1)*x185;
eq204 = (lambda1 + lambda2 + mu1*12 + mu2*1)*x187 == lambda1*x177 + lambda2*x186 + mu1*(12 + 1)*x196 + mu2*(1+1)*x188;
eq205 = (lambda1 + lambda2 + mu1*12 + mu2*2)*x188 == lambda1*x178 + lambda2*x187 + mu1*(12 + 1)*x197 + mu2*(2+1)*x189;
eq206 = (lambda1 + lambda2 + mu1*12 + mu2*3)*x189 == lambda1*x179 + lambda2*x188 + mu1*(12 + 1)*x198 + mu2*(3+1)*x190;
eq207 = (lambda1 + lambda2 + mu1*12 + mu2*4)*x190 == lambda1*x180 + lambda2*x189 + mu1*(12 + 1)*x199 + mu2*(4+1)*x191;
eq208 = (lambda1 + lambda2 + mu1*12 + mu2*5)*x191 == lambda1*x181 + lambda2*x190 + mu1*(12 + 1)*x200 + mu2*(5+1)*x192;
eq209 = (lambda1 + lambda2 + mu1*12 + mu2*6)*x192 == lambda1*x182 + lambda2*x191 + mu1*(12 + 1)*x201 + mu2*(6+1)*x193;
eq210 = (lambda1 + lambda2 + mu1*12 + mu2*7)*x193 == lambda1*x183 + lambda2*x192 + mu1*(12 + 1)*x202 + mu2*(7+1)*x194;
eq211 = (lambda1 + lambda2 + mu1*13 + mu2*1)*x196 == lambda1*x187 + lambda2*x195 + mu1*(13 + 1)*x204 + mu2*(1+1)*x197;
eq212 = (lambda1 + lambda2 + mu1*13 + mu2*2)*x197 == lambda1*x188 + lambda2*x196 + mu1*(13 + 1)*x205 + mu2*(2+1)*x198;
eq213 = (lambda1 + lambda2 + mu1*13 + mu2*3)*x198 == lambda1*x189 + lambda2*x197 + mu1*(13 + 1)*x206 + mu2*(3+1)*x199;
eq214 = (lambda1 + lambda2 + mu1*13 + mu2*4)*x199 == lambda1*x190 + lambda2*x198 + mu1*(13 + 1)*x207 + mu2*(4+1)*x200;
eq215 = (lambda1 + lambda2 + mu1*13 + mu2*5)*x200 == lambda1*x191 + lambda2*x199 + mu1*(13 + 1)*x208 + mu2*(5+1)*x201;
eq216 = (lambda1 + lambda2 + mu1*13 + mu2*6)*x201 == lambda1*x192 + lambda2*x200 + mu1*(13 + 1)*x209 + mu2*(6+1)*x202;
eq217 = (lambda1 + lambda2 + mu1*14 + mu2*1)*x204 == lambda1*x196 + lambda2*x203 + mu1*(14 + 1)*x211 + mu2*(1+1)*x205;
eq218 = (lambda1 + lambda2 + mu1*14 + mu2*2)*x205 == lambda1*x197 + lambda2*x204 + mu1*(14 + 1)*x212 + mu2*(2+1)*x206;
eq219 = (lambda1 + lambda2 + mu1*14 + mu2*3)*x206 == lambda1*x198 + lambda2*x205 + mu1*(14 + 1)*x213 + mu2*(3+1)*x207;
eq220 = (lambda1 + lambda2 + mu1*14 + mu2*4)*x207 == lambda1*x199 + lambda2*x206 + mu1*(14 + 1)*x214 + mu2*(4+1)*x208;
eq221 = (lambda1 + lambda2 + mu1*14 + mu2*5)*x208 == lambda1*x200 + lambda2*x207 + mu1*(14 + 1)*x215 + mu2*(5+1)*x209;
eq222 = (lambda1 + lambda2 + mu1*15 + mu2*1)*x211 == lambda1*x204 + lambda2*x210 + mu1*(15 + 1)*x217 + mu2*(1+1)*x212;
eq223 = (lambda1 + lambda2 + mu1*15 + mu2*2)*x212 == lambda1*x205 + lambda2*x211 + mu1*(15 + 1)*x218 + mu2*(2+1)*x213;
eq224 = (lambda1 + lambda2 + mu1*15 + mu2*3)*x213 == lambda1*x206 + lambda2*x212 + mu1*(15 + 1)*x219 + mu2*(3+1)*x214;
eq225 = (lambda1 + lambda2 + mu1*15 + mu2*4)*x214 == lambda1*x207 + lambda2*x213 + mu1*(15 + 1)*x220 + mu2*(4+1)*x215;
eq226 = (lambda1 + lambda2 + mu1*16 + mu2*1)*x217 == lambda1*x211 + lambda2*x216 + mu1*(16 + 1)*x222 + mu2*(1+1)*x218;
eq227 = (lambda1 + lambda2 + mu1*16 + mu2*2)*x218 == lambda1*x212 + lambda2*x217 + mu1*(16 + 1)*x223 + mu2*(2+1)*x219;
eq228 = (lambda1 + lambda2 + mu1*16 + mu2*3)*x219 == lambda1*x213 + lambda2*x218 + mu1*(16 + 1)*x224 + mu2*(3+1)*x220;
eq229 = (lambda1 + lambda2 + mu1*17 + mu2*1)*x222 == lambda1*x217 + lambda2*x221 + mu1*(17 + 1)*x226 + mu2*(1+1)*x223;
eq230 = (lambda1 + lambda2 + mu1*17 + mu2*2)*x223 == lambda1*x218 + lambda2*x222 + mu1*(17 + 1)*x227 + mu2*(2+1)*x224;
eq231 = (lambda1 + lambda2 + mu1*18 + mu2*1)*x226 == lambda1*x222 + lambda2*x225 + mu1*(18 + 1)*x229 + mu2*(1+1)*x227;
eq0 = x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9 + x10 + x11 + x12 + x13 + x14 + x15 + x16 + x17 + x18 + x19 + x20 + x21 + x22 + x23 + x24 + x25 + x26 + x27 + x28 + x29 + x30 + x31 + x32 + x33 + x34 + x35 + x36 + x37 + x38 + x39 + x40 + x41 + x42 + x43 + x44 + x45 + x46 + x47 + x48 + x49 + x50 + x51 + x52 + x53 + x54 + x55 + x56 + x57 + x58 + x59 + x60 + x61 + x62 + x63 + x64 + x65 + x66 + x67 + x68 + x69 + x70 + x71 + x72 + x73 + x74 + x75 + x76 + x77 + x78 + x79 + x80 + x81 + x82 + x83 + x84 + x85 + x86 + x87 + x88 + x89 + x90 + x91 + x92 + x93 + x94 + x95 + x96 + x97 + x98 + x99 + x100 + x101 + x102 + x103 + x104 + x105 + x106 + x107 + x108 + x109 + x110 + x111 + x112 + x113 + x114 + x115 + x116 + x117 + x118 + x119 + x120 + x121 + x122 + x123 + x124 + x125 + x126 + x127 + x128 + x129 + x130 + x131 + x132 + x133 + x134 + x135 + x136 + x137 + x138 + x139 + x140 + x141 + x142 + x143 + x144 + x145 + x146 + x147 + x148 + x149 + x150 + x151 + x152 + x153 + x154 + x155 + x156 + x157 + x158 + x159 + x160 + x161 + x162 + x163 + x164 + x165 + x166 + x167 + x168 + x169 + x170 + x171 + x172 + x173 + x174 + x175 + x176 + x177 + x178 + x179 + x180 + x181 + x182 + x183 + x184 + x185 + x186 + x187 + x188 + x189 + x190 + x191 + x192 + x193 + x194 + x195 + x196 + x197 + x198 + x199 + x200 + x201 + x202 + x203 + x204 + x205 + x206 + x207 + x208 + x209 + x210 + x211 + x212 + x213 + x214 + x215 + x216 + x217 + x218 + x219 + x220 + x221 + x222 + x223 + x224 + x225 + x226 + x227 + x228 + x229 + x230 + x231 == 1;
solution = solve(eq0,eq1,eq2,eq3,eq4,eq5,eq6,eq7,eq8,eq9,eq10,eq11,eq12,eq13,eq14,eq15,eq16,eq17,eq18,eq19,eq20,eq21,eq22,eq23,eq24,eq25,eq26,eq27,eq28,eq29,eq30,eq31,eq32,eq33,eq34,eq35,eq36,eq37,eq38,eq39,eq40,eq41,eq42,eq43,eq44,eq45,eq46,eq47,eq48,eq49,eq50,eq51,eq52,eq53,eq54,eq55,eq56,eq57,eq58,eq59,eq60,eq61,eq62,eq63,eq64,eq65,eq66,eq67,eq68,eq69,eq70,eq71,eq72,eq73,eq74,eq75,eq76,eq77,eq78,eq79,eq80,eq81,eq82,eq83,eq84,eq85,eq86,eq87,eq88,eq89,eq90,eq91,eq92,eq93,eq94,eq95,eq96,eq97,eq98,eq99,eq100,eq101,eq102,eq103,eq104,eq105,eq106,eq107,eq108,eq109,eq110,eq111,eq112,eq113,eq114,eq115,eq116,eq117,eq118,eq119,eq120,eq121,eq122,eq123,eq124,eq125,eq126,eq127,eq128,eq129,eq130,eq131,eq132,eq133,eq134,eq135,eq136,eq137,eq138,eq139,eq140,eq141,eq142,eq143,eq144,eq145,eq146,eq147,eq148,eq149,eq150,eq151,eq152,eq153,eq154,eq155,eq156,eq157,eq158,eq159,eq160,eq161,eq162,eq163,eq164,eq165,eq166,eq167,eq168,eq169,eq170,eq171,eq172,eq173,eq174,eq175,eq176,eq177,eq178,eq179,eq180,eq181,eq182,eq183,eq184,eq185,eq186,eq187,eq188,eq189,eq190,eq191,eq192,eq193,eq194,eq195,eq196,eq197,eq198,eq199,eq200,eq201,eq202,eq203,eq204,eq205,eq206,eq207,eq208,eq209,eq210,eq211,eq212,eq213,eq214,eq215,eq216,eq217,eq218,eq219,eq220,eq221,eq222,eq223,eq224,eq225,eq226,eq227,eq228,eq229,eq230,eq231,x0,x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11,x12,x13,x14,x15,x16,x17,x18,x19,x20,x21,x22,x23,x24,x25,x26,x27,x28,x29,x30,x31,x32,x33,x34,x35,x36,x37,x38,x39,x40,x41,x42,x43,x44,x45,x46,x47,x48,x49,x50,x51,x52,x53,x54,x55,x56,x57,x58,x59,x60,x61,x62,x63,x64,x65,x66,x67,x68,x69,x70,x71,x72,x73,x74,x75,x76,x77,x78,x79,x80,x81,x82,x83,x84,x85,x86,x87,x88,x89,x90,x91,x92,x93,x94,x95,x96,x97,x98,x99,x100,x101,x102,x103,x104,x105,x106,x107,x108,x109,x110,x111,x112,x113,x114,x115,x116,x117,x118,x119,x120,x121,x122,x123,x124,x125,x126,x127,x128,x129,x130,x131,x132,x133,x134,x135,x136,x137,x138,x139,x140,x141,x142,x143,x144,x145,x146,x147,x148,x149,x150,x151,x152,x153,x154,x155,x156,x157,x158,x159,x160,x161,x162,x163,x164,x165,x166,x167,x168,x169,x170,x171,x172,x173,x174,x175,x176,x177,x178,x179,x180,x181,x182,x183,x184,x185,x186,x187,x188,x189,x190,x191,x192,x193,x194,x195,x196,x197,x198,x199,x200,x201,x202,x203,x204,x205,x206,x207,x208,x209,x210,x211,x212,x213,x214,x215,x216,x217,x218,x219,x220,x221,x222,x223,x224,x225,x226,x227,x228,x229,x230,x231);

AverageNumberOfClass1JobCloudlet = 0 + 0*solution.x0 + 0*solution.x1 + 0*solution.x2 + 0*solution.x3 + 0*solution.x4 + 0*solution.x5 + 0*solution.x6 + 0*solution.x7 + 0*solution.x8 + 0*solution.x9 + 0*solution.x10 + 0*solution.x11 + 0*solution.x12 + 0*solution.x13 + 0*solution.x14 + 0*solution.x15 + 0*solution.x16 + 0*solution.x17 + 0*solution.x18 + 0*solution.x19 + 0*solution.x20 + 1*solution.x21 + 1*solution.x22 + 1*solution.x23 + 1*solution.x24 + 1*solution.x25 + 1*solution.x26 + 1*solution.x27 + 1*solution.x28 + 1*solution.x29 + 1*solution.x30 + 1*solution.x31 + 1*solution.x32 + 1*solution.x33 + 1*solution.x34 + 1*solution.x35 + 1*solution.x36 + 1*solution.x37 + 1*solution.x38 + 1*solution.x39 + 1*solution.x40 + 2*solution.x41 + 2*solution.x42 + 2*solution.x43 + 2*solution.x44 + 2*solution.x45 + 2*solution.x46 + 2*solution.x47 + 2*solution.x48 + 2*solution.x49 + 2*solution.x50 + 2*solution.x51 + 2*solution.x52 + 2*solution.x53 + 2*solution.x54 + 2*solution.x55 + 2*solution.x56 + 2*solution.x57 + 2*solution.x58 + 2*solution.x59 + 3*solution.x60 + 3*solution.x61 + 3*solution.x62 + 3*solution.x63 + 3*solution.x64 + 3*solution.x65 + 3*solution.x66 + 3*solution.x67 + 3*solution.x68 + 3*solution.x69 + 3*solution.x70 + 3*solution.x71 + 3*solution.x72 + 3*solution.x73 + 3*solution.x74 + 3*solution.x75 + 3*solution.x76 + 3*solution.x77 + 4*solution.x78 + 4*solution.x79 + 4*solution.x80 + 4*solution.x81 + 4*solution.x82 + 4*solution.x83 + 4*solution.x84 + 4*solution.x85 + 4*solution.x86 + 4*solution.x87 + 4*solution.x88 + 4*solution.x89 + 4*solution.x90 + 4*solution.x91 + 4*solution.x92 + 4*solution.x93 + 4*solution.x94 + 5*solution.x95 + 5*solution.x96 + 5*solution.x97 + 5*solution.x98 + 5*solution.x99 + 5*solution.x100 + 5*solution.x101 + 5*solution.x102 + 5*solution.x103 + 5*solution.x104 + 5*solution.x105 + 5*solution.x106 + 5*solution.x107 + 5*solution.x108 + 5*solution.x109 + 5*solution.x110 + 6*solution.x111 + 6*solution.x112 + 6*solution.x113 + 6*solution.x114 + 6*solution.x115 + 6*solution.x116 + 6*solution.x117 + 6*solution.x118 + 6*solution.x119 + 6*solution.x120 + 6*solution.x121 + 6*solution.x122 + 6*solution.x123 + 6*solution.x124 + 6*solution.x125 + 7*solution.x126 + 7*solution.x127 + 7*solution.x128 + 7*solution.x129 + 7*solution.x130 + 7*solution.x131 + 7*solution.x132 + 7*solution.x133 + 7*solution.x134 + 7*solution.x135 + 7*solution.x136 + 7*solution.x137 + 7*solution.x138 + 7*solution.x139 + 8*solution.x140 + 8*solution.x141 + 8*solution.x142 + 8*solution.x143 + 8*solution.x144 + 8*solution.x145 + 8*solution.x146 + 8*solution.x147 + 8*solution.x148 + 8*solution.x149 + 8*solution.x150 + 8*solution.x151 + 8*solution.x152 + 9*solution.x153 + 9*solution.x154 + 9*solution.x155 + 9*solution.x156 + 9*solution.x157 + 9*solution.x158 + 9*solution.x159 + 9*solution.x160 + 9*solution.x161 + 9*solution.x162 + 9*solution.x163 + 9*solution.x164 + 10*solution.x165 + 10*solution.x166 + 10*solution.x167 + 10*solution.x168 + 10*solution.x169 + 10*solution.x170 + 10*solution.x171 + 10*solution.x172 + 10*solution.x173 + 10*solution.x174 + 10*solution.x175 + 11*solution.x176 + 11*solution.x177 + 11*solution.x178 + 11*solution.x179 + 11*solution.x180 + 11*solution.x181 + 11*solution.x182 + 11*solution.x183 + 11*solution.x184 + 11*solution.x185 + 12*solution.x186 + 12*solution.x187 + 12*solution.x188 + 12*solution.x189 + 12*solution.x190 + 12*solution.x191 + 12*solution.x192 + 12*solution.x193 + 12*solution.x194 + 13*solution.x195 + 13*solution.x196 + 13*solution.x197 + 13*solution.x198 + 13*solution.x199 + 13*solution.x200 + 13*solution.x201 + 13*solution.x202 + 14*solution.x203 + 14*solution.x204 + 14*solution.x205 + 14*solution.x206 + 14*solution.x207 + 14*solution.x208 + 14*solution.x209 + 15*solution.x210 + 15*solution.x211 + 15*solution.x212 + 15*solution.x213 + 15*solution.x214 + 15*solution.x215 + 16*solution.x216 + 16*solution.x217 + 16*solution.x218 + 16*solution.x219 + 16*solution.x220 + 17*solution.x221 + 17*solution.x222 + 17*solution.x223 + 17*solution.x224 + 18*solution.x225 + 18*solution.x226 + 18*solution.x227 + 19*solution.x228 + 19*solution.x229 + 20*solution.x230;

AverageNumberOfClass2JobCloudlet = 0 + 0*solution.x0 + 1*solution.x1 + 2*solution.x2 + 3*solution.x3 + 4*solution.x4 + 5*solution.x5 + 6*solution.x6 + 7*solution.x7 + 8*solution.x8 + 9*solution.x9 + 10*solution.x10 + 11*solution.x11 + 12*solution.x12 + 13*solution.x13 + 14*solution.x14 + 15*solution.x15 + 16*solution.x16 + 17*solution.x17 + 18*solution.x18 + 19*solution.x19 + 20*solution.x20 + 0*solution.x21 + 1*solution.x22 + 2*solution.x23 + 3*solution.x24 + 4*solution.x25 + 5*solution.x26 + 6*solution.x27 + 7*solution.x28 + 8*solution.x29 + 9*solution.x30 + 10*solution.x31 + 11*solution.x32 + 12*solution.x33 + 13*solution.x34 + 14*solution.x35 + 15*solution.x36 + 16*solution.x37 + 17*solution.x38 + 18*solution.x39 + 19*solution.x40 + 0*solution.x41 + 1*solution.x42 + 2*solution.x43 + 3*solution.x44 + 4*solution.x45 + 5*solution.x46 + 6*solution.x47 + 7*solution.x48 + 8*solution.x49 + 9*solution.x50 + 10*solution.x51 + 11*solution.x52 + 12*solution.x53 + 13*solution.x54 + 14*solution.x55 + 15*solution.x56 + 16*solution.x57 + 17*solution.x58 + 18*solution.x59 + 0*solution.x60 + 1*solution.x61 + 2*solution.x62 + 3*solution.x63 + 4*solution.x64 + 5*solution.x65 + 6*solution.x66 + 7*solution.x67 + 8*solution.x68 + 9*solution.x69 + 10*solution.x70 + 11*solution.x71 + 12*solution.x72 + 13*solution.x73 + 14*solution.x74 + 15*solution.x75 + 16*solution.x76 + 17*solution.x77 + 0*solution.x78 + 1*solution.x79 + 2*solution.x80 + 3*solution.x81 + 4*solution.x82 + 5*solution.x83 + 6*solution.x84 + 7*solution.x85 + 8*solution.x86 + 9*solution.x87 + 10*solution.x88 + 11*solution.x89 + 12*solution.x90 + 13*solution.x91 + 14*solution.x92 + 15*solution.x93 + 16*solution.x94 + 0*solution.x95 + 1*solution.x96 + 2*solution.x97 + 3*solution.x98 + 4*solution.x99 + 5*solution.x100 + 6*solution.x101 + 7*solution.x102 + 8*solution.x103 + 9*solution.x104 + 10*solution.x105 + 11*solution.x106 + 12*solution.x107 + 13*solution.x108 + 14*solution.x109 + 15*solution.x110 + 0*solution.x111 + 1*solution.x112 + 2*solution.x113 + 3*solution.x114 + 4*solution.x115 + 5*solution.x116 + 6*solution.x117 + 7*solution.x118 + 8*solution.x119 + 9*solution.x120 + 10*solution.x121 + 11*solution.x122 + 12*solution.x123 + 13*solution.x124 + 14*solution.x125 + 0*solution.x126 + 1*solution.x127 + 2*solution.x128 + 3*solution.x129 + 4*solution.x130 + 5*solution.x131 + 6*solution.x132 + 7*solution.x133 + 8*solution.x134 + 9*solution.x135 + 10*solution.x136 + 11*solution.x137 + 12*solution.x138 + 13*solution.x139 + 0*solution.x140 + 1*solution.x141 + 2*solution.x142 + 3*solution.x143 + 4*solution.x144 + 5*solution.x145 + 6*solution.x146 + 7*solution.x147 + 8*solution.x148 + 9*solution.x149 + 10*solution.x150 + 11*solution.x151 + 12*solution.x152 + 0*solution.x153 + 1*solution.x154 + 2*solution.x155 + 3*solution.x156 + 4*solution.x157 + 5*solution.x158 + 6*solution.x159 + 7*solution.x160 + 8*solution.x161 + 9*solution.x162 + 10*solution.x163 + 11*solution.x164 + 0*solution.x165 + 1*solution.x166 + 2*solution.x167 + 3*solution.x168 + 4*solution.x169 + 5*solution.x170 + 6*solution.x171 + 7*solution.x172 + 8*solution.x173 + 9*solution.x174 + 10*solution.x175 + 0*solution.x176 + 1*solution.x177 + 2*solution.x178 + 3*solution.x179 + 4*solution.x180 + 5*solution.x181 + 6*solution.x182 + 7*solution.x183 + 8*solution.x184 + 9*solution.x185 + 0*solution.x186 + 1*solution.x187 + 2*solution.x188 + 3*solution.x189 + 4*solution.x190 + 5*solution.x191 + 6*solution.x192 + 7*solution.x193 + 8*solution.x194 + 0*solution.x195 + 1*solution.x196 + 2*solution.x197 + 3*solution.x198 + 4*solution.x199 + 5*solution.x200 + 6*solution.x201 + 7*solution.x202 + 0*solution.x203 + 1*solution.x204 + 2*solution.x205 + 3*solution.x206 + 4*solution.x207 + 5*solution.x208 + 6*solution.x209 + 0*solution.x210 + 1*solution.x211 + 2*solution.x212 + 3*solution.x213 + 4*solution.x214 + 5*solution.x215 + 0*solution.x216 + 1*solution.x217 + 2*solution.x218 + 3*solution.x219 + 4*solution.x220 + 0*solution.x221 + 1*solution.x222 + 2*solution.x223 + 3*solution.x224 + 0*solution.x225 + 1*solution.x226 + 2*solution.x227 + 0*solution.x228 + 1*solution.x229 + 0*solution.x230;

Class1JobSendToCloudletProbability = 1 - solution.x230;

Class1JobSendToCloudProbability = solution.x230;

Class2JobInterruptionProbability = 0  + solution.x20 + solution.x40 + solution.x59 + solution.x77 + solution.x94 + solution.x110 + solution.x125 + solution.x139 + solution.x152 + solution.x164 + solution.x175 + solution.x185 + solution.x194 + solution.x202 + solution.x209 + solution.x215 + solution.x220 + solution.x224 + solution.x227 + solution.x229;

Class2JobSendToCloudProbability = 0 + solution.x20 + solution.x40 + solution.x59 + solution.x77 + solution.x94 + solution.x110 + solution.x125 + solution.x139 + solution.x152 + solution.x164 + solution.x175 + solution.x185 + solution.x194 + solution.x202 + solution.x209 + solution.x215 + solution.x220 + solution.x224 + solution.x227 + solution.x229 + solution.x230;

Class2JobSendToCloudletProbability = 1 - Class2JobSendToCloudProbability;

% System parameters...
% ----------------------------------------------------------------------- %

CLOUDLET_mu_class_1 = sym(0.45);
CLOUDLET_mu_class_2 = sym(0.27);

CLOUD_mu_class_1 = sym(0.25);
CLOUD_mu_class_2 = sym(0.22);

P_INTERRUPT = Class2JobInterruptionProbability * Class1JobSendToCloudletProbability;

CLOUDLET_LAMBDA_CLASS_1 = lambda1 * Class1JobSendToCloudletProbability;
CLOUDLET_LAMBDA_CLASS_2 = lambda2 * Class2JobSendToCloudletProbability;

CLOUD_LAMBDA_CLASS_1 = lambda1 * Class1JobSendToCloudProbability;
CLOUD_LAMBDA_CLASS_2 = lambda2 * Class2JobSendToCloudProbability + CLOUDLET_LAMBDA_CLASS_2 * P_INTERRUPT;
INTERRUPTED_JOB_RATE = CLOUDLET_LAMBDA_CLASS_2 * P_INTERRUPT;

% THROUGHPUT

CLOUDLET_THROUGHPUT_CLASS_1 = CLOUDLET_LAMBDA_CLASS_1;
CLOUDLET_THROUGHPUT_CLASS_2 = CLOUDLET_LAMBDA_CLASS_2 - INTERRUPTED_JOB_RATE;
CLOUDLET_THROUGHPUT = CLOUDLET_THROUGHPUT_CLASS_1 + CLOUDLET_THROUGHPUT_CLASS_2;

CLOUD_THROUGHPUT_CLASS_1 = CLOUD_LAMBDA_CLASS_1;
CLOUD_THROUGHPUT_CLASS_2 = CLOUD_LAMBDA_CLASS_2;
CLOUD_THROUGHPUT = CLOUD_THROUGHPUT_CLASS_1 + CLOUD_THROUGHPUT_CLASS_2;

% POPULATION

CLOUDLET_POPULATION_CLASS_1 = AverageNumberOfClass1JobCloudlet;
CLOUDLET_POPULATION_CLASS_2 = AverageNumberOfClass2JobCloudlet;
CLOUDLET_POPULATION = CLOUDLET_POPULATION_CLASS_1 + CLOUDLET_POPULATION_CLASS_2;

CLOUD_POPULATION_CLASS_1 = CLOUD_LAMBDA_CLASS_1 / CLOUD_mu_class_1;
CLOUD_POPULATION_CLASS_2 = CLOUD_LAMBDA_CLASS_2 / CLOUD_mu_class_2;
CLOUD_POPULATION = CLOUD_POPULATION_CLASS_1 + CLOUD_POPULATION_CLASS_2;

CLOUDLET_SERVICE_TIME = sym(CLOUDLET_mu_class_1^(-1))*(CLOUDLET_LAMBDA_CLASS_1)/(CLOUDLET_LAMBDA_CLASS_1+CLOUDLET_LAMBDA_CLASS_2- CLOUDLET_LAMBDA_CLASS_2 * P_INTERRUPT) + sym(CLOUDLET_mu_class_2^(-1))*(CLOUDLET_LAMBDA_CLASS_2 - CLOUDLET_LAMBDA_CLASS_2 * P_INTERRUPT)/(CLOUDLET_LAMBDA_CLASS_1+CLOUDLET_LAMBDA_CLASS_2- CLOUDLET_LAMBDA_CLASS_2 * P_INTERRUPT);
CLOUD_SERVICE_TIME = sym(CLOUD_mu_class_1^(-1))*(CLOUD_LAMBDA_CLASS_1)/(CLOUD_LAMBDA_CLASS_1+CLOUD_LAMBDA_CLASS_2) + sym(CLOUD_mu_class_2^(-1))*(CLOUD_LAMBDA_CLASS_2)/(CLOUD_LAMBDA_CLASS_1+CLOUD_LAMBDA_CLASS_2);

GLOBAL_SERVICE_TIME_CLASS_1 = Class1JobSendToCloudletProbability * sym(CLOUDLET_mu_class_1^(-1)) + Class1JobSendToCloudProbability * sym(CLOUD_mu_class_1^(-1));
GLOBAL_SERVICE_TIME_CLASS_2 = Class2JobSendToCloudletProbability * ( P_INTERRUPT * (0.8 + sym(CLOUD_mu_class_2^(-1))) + (1 - P_INTERRUPT)*sym(CLOUDLET_mu_class_2^(-1))) + Class2JobSendToCloudProbability*sym(CLOUD_mu_class_2^(-1));
GLOBAL_SERVICE_TIME = GLOBAL_SERVICE_TIME_CLASS_1*(lambda1)/(lambda1+lambda2) + GLOBAL_SERVICE_TIME_CLASS_2*(lambda2)/(lambda1+lambda2);

GLOBAL_POPULATION_CLASS_1 = GLOBAL_SERVICE_TIME_CLASS_1*(lambda1);
GLOBAL_POPULATION_CLASS_2 = GLOBAL_SERVICE_TIME_CLASS_2*(lambda2);
GLOBAL_POPULATION_CLASS = GLOBAL_POPULATION_CLASS_1 + GLOBAL_POPULATION_CLASS_2;



