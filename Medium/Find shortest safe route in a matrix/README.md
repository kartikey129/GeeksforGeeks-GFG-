<h2><a href="https://www.geeksforgeeks.org/problems/find-shortest-safe-route-in-a-matrix/1">Find shortest safe route in a matrix</a></h2><h3>Difficulty Level : Medium</h3><hr><div class="problems_problem_content__Xm_eO" element-id="136"><p element-id="135"><span style="font-size: 18px;" element-id="134">Given a matrix <strong element-id="133">mat[][] with r </strong>rows and <strong element-id="132">c </strong>columns, where some cells are landmines <strong element-id="131">(marked as 0)</strong> and others are safe to traverse. Your task is to <strong element-id="130">find the shortest safe route</strong> from <strong element-id="129">any cell</strong> in the leftmost column to <strong element-id="128">any cell</strong> in the rightmost column of the <strong element-id="127">mat</strong>. <strong element-id="126">You cannot move diagonally</strong>, and you must <strong element-id="125">avoid both the landmines</strong> and <strong element-id="124">their adjacent</strong> cells (up, down, left, right), as they are also <strong element-id="123">unsafe</strong>.</span></p>
<p element-id="122"><strong element-id="121"><span style="font-size: 18px;" element-id="120">Example 1:</span></strong></p>
<pre element-id="119"><strong element-id="118"><span style="font-size: 18px;" element-id="117">Input:</span></strong>
<span style="font-size: 18px;" element-id="116">mat = [1, 0, 1, 1, 1],
      [1, 1, 1, 1, 1],
      [1, 1, 1, 1, 1],
      [1, 1, 1, 0, 1],
      [1, 1, 1, 1, 0]</span>
<strong element-id="115"><span style="font-size: 18px;" element-id="114">Output: <br element-id="113"></span></strong><span style="font-size: 18px;" element-id="112">6</span>
<strong element-id="111"><span style="font-size: 18px;" element-id="110">Explanation: </span></strong>
<span style="font-size: 18px;" element-id="109">We can see that length of shortest</span>
<span style="font-size: 18px;" element-id="108">safe route is 6</span>
<span style="font-size: 14pt;" element-id="107">[1 0 1 1 1]<br element-id="106">[1 1 <span style="color: #236fa1;" element-id="105"><strong element-id="104">1</strong> <strong element-id="103">1</strong> <strong element-id="102">1</strong></span>]<span style="color: #236fa1;" element-id="101"><br element-id="100"></span>[<span style="color: #236fa1;" element-id="99"><strong element-id="98">1</strong></span> <span style="color: #236fa1;" element-id="97"><strong element-id="96">1</strong></span> <span style="color: #236fa1;" element-id="95"><strong element-id="94">1</strong></span> 1 1]
[1 1 1 0 1] 
[1 1 1 1 0]
</span></pre>
<p element-id="93"><strong element-id="92"><span style="font-size: 18px;" element-id="91">Example 2:</span></strong></p>
<pre element-id="90"><strong element-id="89"><span style="font-size: 18px;" element-id="88">Input:</span></strong><span style="font-size: 18px;" element-id="87">
mat = [1, 1, 1, 1, 1],
      [1, 1, 0, 1, 1],
      [1, 1, 1, 1, 1]</span><strong element-id="86"><span style="font-size: 18px;" element-id="85">
Output: <br element-id="84"></span></strong><span style="font-size: 18px;" element-id="83">-1</span><strong element-id="82"><span style="font-size: 18px;" element-id="81">
Explanation: </span></strong><span style="font-size: 18px;" element-id="80">There is no possible path from
first column to last column.</span></pre>
<p element-id="79"><span style="font-size: 18px;" element-id="78"><strong element-id="77">Your Task:</strong><br element-id="76">You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong element-id="75">findShortestPath()&nbsp;</strong>which takes the matrix as an input parameter and returns an integer denoting the shortest safe path from <strong element-id="74">any cell</strong> in the leftmost column to <strong element-id="73">any cell </strong>in the rightmost column of <strong element-id="72">mat</strong>. If there is no possible path, return <strong element-id="71">-1</strong>.&nbsp;<br element-id="70"></span></p>
<p element-id="69"><span style="font-size: 18px;" element-id="68"><strong element-id="67">Expected Time Complexity:</strong> O(r * c)<br element-id="66"><strong element-id="65">Expected Auxiliary Space:</strong> O(</span><span style="font-size: 18px;" element-id="64">r * c</span><span style="font-size: 18px;" element-id="63">)</span></p>
<p element-id="62"><span style="font-size: 18px;" element-id="61"><strong element-id="60">Constraints:</strong><br element-id="59">1 &lt;= r, c &lt;= 10</span><sup element-id="58"><span style="font-size: 15px;" element-id="57">3<br element-id="56">0 &lt;= mat[][] &lt;= 1</span></sup></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>DFS</code>&nbsp;<code>Graph</code>&nbsp;