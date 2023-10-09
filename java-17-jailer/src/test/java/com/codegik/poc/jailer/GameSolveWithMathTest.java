package com.codegik.poc.jailer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GameSolveWithMathTest {
	private GameSolveWithMath game = new GameSolveWithMath();

	@Test
	void awfulCandyGoesToChair1() {
		var result = game.awfulCandyGoesTo(5, 2, 5);
		var expected = 1;

		assertEquals(expected, result);
	}

	@Test
	void awfulCandyGoesToChair2() {
		var result = game.awfulCandyGoesTo(5, 2, 1);
		var expected = 2;
		assertEquals(expected, result);
	}

	@Test
	void awfulCandyGoesToChair3() {
		var result = game.awfulCandyGoesTo(3, 7, 1);
		var expected = 1;
		assertEquals(expected, result);
	}

	@Test
	void awfulCandyGoesToChair6() {
		var result = game.awfulCandyGoesTo(7, 25, 5);
		var expected = 1;
		assertEquals(expected, result);
	}

	@Test
	void awfulCandyGoesToChair72975907() {
		var result = game.awfulCandyGoesTo(208526924, 756265725, 150817879);
		var expected = 72975907;
		assertEquals(expected, result);
	}

	// 13 140874526	1 = 13
	@Test
	void awfulCandyGoesToChair13() {
		var result = game.awfulCandyGoesTo(13, 140874526, 1);
		var expected = 13;
		assertEquals(expected, result);
	}

	@Test
	void batchTest() {
		var inputs = "352926151\t380324688\t94730870\t122129406\n" +
				"94431605\t679262176\t5284458\t23525398\n" +
				"208526924\t756265725\t150817879\t72975907\n" +
				"962975336\t972576181\t396355184\t405956028\n" +
				"464237185\t937820284\t255816794\t265162707\n" +
				"649320641\t742902564\t647542323\t91803604\n" +
				"174512033\t711706897\t68977959\t82636723\n" +
				"107283902\t156676511\t67149447\t9258153\n" +
				"104513201\t298399273\t96292548\t81152217\n" +
				"113378824\t274011418\t98103763\t31978708\n" +
				"934815799\t991959468\t212396037\t269539705\n" +
				"88325121\t435452998\t24617705\t18445097\n" +
				"984873585\t997634055\t103050157\t115810626\n" +
				"344218387\t715364875\t90658180\t117586280\n" +
				"556065259\t615709967\t156417592\t216062299\n" +
				"57109959\t451440582\t4188603\t55859471\n" +
				"353972922\t573651462\t244520504\t110226121\n" +
				"946486979\t973168361\t647886035\t674567416\n" +
				"368127406\t680428368\t105517295\t49690850\n" +
				"884634320\t965112925\t119757238\t200235842\n" +
				"422557970\t744431033\t28932300\t350805362\n" +
				"634954007\t957414623\t341366379\t28872987\n" +
				"190265362\t445253893\t184632922\t59090728\n" +
				"293315518\t479153471\t120684020\t13206454\n" +
				"72410472\t80198999\t984948\t8773474\n" +
				"784893322\t849791807\t360911386\t425809870\n" +
				"846191883\t880790237\t510053756\t544652109\n" +
				"297201660\t812278057\t198376746\t119049822\n" +
				"945087694\t999220046\t465061514\t519193865\n" +
				"786859800\t831171414\t378370933\t422682546\n" +
				"528402029\t859318899\t224559950\t27074790\n" +
				"522640531\t755821672\t28838424\t262019564\n" +
				"864006909\t879474138\t806467486\t821934714\n" +
				"613544440\t943850900\t258190755\t588497214\n" +
				"734228459\t928771704\t265979283\t460522527\n" +
				"542812502\t597832172\t330877768\t385897437\n" +
				"541133561\t748691081\t126348492\t333906011\n" +
				"51187317\t524866691\t1143193\t14136713\n" +
				"885290374\t990676850\t373368385\t478754860\n" +
				"147955933\t450823700\t138416059\t145371959\n" +
				"100046465\t587967212\t32555061\t20243482\n" +
				"233926824\t996957988\t31809378\t93060069\n" +
				"785405778\t835771758\t689182705\t739548684\n" +
				"444389615\t870657324\t72775880\t54653973\n" +
				"702580369\t895325888\t345053199\t537798717\n" +
				"968559651\t974760313\t326732084\t332932745\n" +
				"299437419\t514618345\t254272806\t170016312\n" +
				"901702945\t930227426\t727030891\t755555371\n" +
				"721843209\t736359383\t225283784\t239799957\n" +
				"833018320\t883439261\t806599246\t24001866\n" +
				"267346244\t307857609\t46989880\t87501244\n" +
				"299901304\t892163356\t210218436\t202677879\n" +
				"565637506\t795821687\t158300457\t388484637\n" +
				"107336562\t781910357\t54488503\t85042925\n" +
				"513281286\t916998022\t254269425\t144704874\n" +
				"413431205\t611661371\t188998419\t387228584\n" +
				"740163288\t938647312\t571382392\t29703127\n" +
				"44702121\t296589002\t43470596\t27144750\n" +
				"771733011\t919327188\t317638907\t465233083\n" +
				"718860003\t815844769\t495144331\t592129096\n" +
				"377975600\t438513404\t111085209\t171623012\n" +
				"424965480\t928959619\t20776133\t99804791\n" +
				"234986523\t732169039\t205952749\t233162218\n" +
				"377078343\t981597420\t219264561\t69626951\n" +
				"612269027\t791414524\t580170106\t147046575\n" +
				"232336090\t616084008\t81392003\t467740\n" +
				"75059328\t274029861\t53524881\t27317429\n" +
				"239121359\t646856043\t141349731\t70841696\n" +
				"923193147\t943368157\t206717532\t226892541\n" +
				"12565064\t536852817\t11557940\t8113004\n" +
				"360225746\t970375527\t284883902\t174582190\n" +
				"213705306\t380885426\t14495860\t181675979\n" +
				"659446919\t699401237\t73837176\t113791493\n" +
				"335372713\t785363124\t7610828\t122228525\n" +
				"538388654\t859196325\t110284314\t431091984\n" +
				"118558760\t713483972\t83950807\t86082218\n" +
				"896959032\t961368580\t8848444\t73257991\n" +
				"25543240\t521123082\t2472730\t12731011\n" +
				"258530682\t935834352\t194732411\t96444034\n" +
				"465248213\t679599042\t334563499\t83666114\n" +
				"331230504\t637771661\t76778140\t52088792\n" +
				"976340152\t988657462\t243958260\t256275569\n" +
				"552994811\t922743535\t540135280\t356889192\n" +
				"626831986\t839281366\t24222267\t236671646\n" +
				"157704591\t253731033\t59023773\t155050214\n" +
				"806377559\t859228114\t238044289\t290894843\n" +
				"838798445\t996851254\t268459446\t426512254\n" +
				"847646888\t928001503\t755190846\t835545460\n" +
				"877625009\t999275937\t874127074\t118152992\n" +
				"847949466\t893343194\t10497830\t55891557\n" +
				"35029316\t784675240\t8200127\t22230414\n" +
				"111807455\t690309882\t23190325\t42655476\n" +
				"355765714\t554560093\t311565654\t154594318\n" +
				"1890615\t614626804\t976253\t1153181\n" +
				"132293206\t165429783\t65360680\t98497256\n" +
				"506726160\t934170235\t455394293\t376112207\n" +
				"210041918\t328800789\t159203369\t67920321\n" +
				"499999999\t999999997\t2\t499999999\n" +
				"499999999\t999999998\t2\t1\n" +
				"999999999\t999999999\t1\t999999999\n" +

				"3\t394274638\t3\t3\n" +
				"7\t615562705\t2\t3\n" +
				"2\t739424390\t2\t1\n" +
				"654809340\t204894365\t472730208\t22815232\n" +
				"12\t430895283\t10\t12\n" +
				"820162082\t641616307\t588599124\t410053348\n" +
				"11\t872829055\t1\t10\n" +
				"8\t863472675\t5\t7\n" +
				"6\t737005495\t6\t6\n" +
				"13\t140874526\t1\t13\n" +
				"5\t838370030\t1\t5\n" +
				"7987995\t944258007\t3704096\t5378692\n" +
				"20\t452477339\t2\t20\n" +
				"16\t316486845\t3\t15\n" +
				"7\t371704047\t4\t4\n" +
				"10\t847309774\t1\t4\n" +
				"19\t326960619\t13\t5\n" +
				"10\t995691642\t9\t10\n" +
				"7\t116507988\t3\t4\n" +
				"8\t94123457\t3\t3\n" +
				"5\t559772387\t5\t1\n" +
				"8\t68776125\t2\t6\n" +
				"2\t950135853\t2\t2\n" +
				"10\t871101260\t5\t4\n" +
				"7\t202574414\t2\t1\n" +
				"18\t179098809\t5\t1\n" +
				"2\t241943014\t1\t2\n" +
				"796\t906236986\t70\t607\n" +
				"10\t351834097\t7\t3\n" +
				"17\t807384911\t17\t17\n" +
				"8\t315277218\t2\t3\n" +
				"1\t809644535\t1\t1\n" +
				"10\t817801950\t3\t2\n" +
				"5\t440531117\t5\t1\n" +
				"20\t880268919\t8\t6\n" +
				"6\t293435347\t2\t2\n" +
				"18\t19114015\t3\t15\n" +
				"4\t735038152\t3\t2\n" +
				"622\t756206857\t245\t27\n" +
				"7\t482235723\t6\t2\n" +
				"1\t332585626\t1\t1\n" +
				"3\t917360179\t1\t1\n" +
				"7\t382333528\t5\t7\n" +
				"3\t910271929\t2\t2\n" +
				"2\t559295142\t1\t2\n" +
				"6\t852399876\t4\t3\n" +
				"5\t507841274\t3\t1\n" +
				"8\t703690620\t7\t2\n" +
				"2\t731894216\t1\t2\n" +
				"15\t315371646\t13\t3\n" +
				"12\t450649452\t4\t3\n" +
				"7\t100332753\t7\t2\n" +
				"9\t304145150\t8\t3\n" +
				"7\t80202029\t5\t2\n" +
				"1\t269193929\t1\t1\n" +
				"18\t950000152\t5\t8\n" +
				"45900\t625548176\t41768\t18843\n" +
				"9\t980493422\t6\t1\n" +
				"2\t59893403\t2\t2\n" +
				"10\t397424389\t1\t9\n" +
				"20\t659990005\t9\t13\n" +
				"8\t962771014\t1\t6\n" +
				"1\t582734799\t1\t1\n" +
				"1\t962681512\t1\t1\n" +
				"1\t176253776\t1\t1\n" +
				"7\t778510859\t2\t1\n" +
				"9\t182827716\t2\t7\n" +
				"5\t846583622\t2\t3\n" +
				"18\t570581961\t6\t2\n" +
				"17\t446480767\t11\t2\n" +
				"10\t483724534\t6\t9\n" +
				"3\t11307206\t1\t2\n" +
				"7\t584440269\t1\t7\n" +
				"14\t697311573\t8\t14\n" +
				"4\t999357627\t1\t3\n" +
				"17\t199341423\t9\t9\n" +
				"7\t457329882\t2\t3\n" +
				"6\t640291708\t3\t6\n" +
				"10\t879791830\t8\t7\n" +
				"3\t269794978\t3\t3\n" +
				"3\t70223500\t3\t3\n" +
				"8\t29789831\t5\t3\n" +
				"1\t982193421\t1\t1\n" +
				"5\t614503262\t5\t1\n" +
				"2\t511908640\t2\t1\n" +
				"8\t256981399\t7\t5\n" +
				"5\t230221644\t4\t2\n" +
				"6\t131578521\t3\t5\n" +
				"7\t421457224\t1\t6\n" +
				"1\t528381267\t1\t1\n" +
				"4\t296324763\t1\t3\n" +
				"13\t413984801\t9\t4\n" +
				"15\t24726509\t13\t11\n" +
				"3\t258277558\t3\t3\n" +
				"15\t837095618\t13\t5\n" +
				"1\t17894198\t1\t1\n" +
				"93327\t722377177\t12125\t38321\n" +
				"3830347\t568814045\t3368104\t1460445\n" +
				"12\t10766669\t6\t10\n" +
				"8\t117991680\t2\t1";
		var testCases = inputs.split("\n");

		for (int i = 0; i < testCases.length; i++) {
			var parameters = testCases[i].split("\t");
			int prisoners = Integer.parseInt(parameters[0]);
			int candyPieces = Integer.parseInt(parameters[1]);
			int startAt = Integer.parseInt(parameters[2]);
			int expected = Integer.parseInt(parameters[3]);
			var result = game.awfulCandyGoesTo(prisoners, candyPieces, startAt);

			System.out.println("testing prisoners: " + prisoners + ", candyPieces: " + candyPieces + ", startAt: " + startAt + " -> " + (expected == result));
			assertEquals(expected, result);
		}
	}

}
