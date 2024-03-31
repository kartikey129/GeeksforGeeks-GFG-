<h2><a href="https://www.geeksforgeeks.org/problems/city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/1">City With the Smallest Number of Neighbors at a Threshold Distance</a></h2><h3>Difficulty Level : Medium</h3><hr><div class="problems_problem_content__Xm_eO" element-id="303"><p element-id="302"><span style="font-size: 18px;" element-id="301">There are <strong element-id="300">n</strong> cities labeled from 0 to n-1 with <strong element-id="299">m </strong>edges connecting them. Given the array <strong element-id="298">edges</strong>&nbsp;where <strong element-id="297">edges[i] = [from<sub element-id="296">i&nbsp;</sub>, to<sub element-id="295">i ,</sub>weight<sub element-id="294">i</sub>]<sub element-id="293">&nbsp;</sub></strong>&nbsp;represents a <strong element-id="292">bidirectional </strong>and <strong element-id="291">weighted edge </strong>between cities <strong element-id="290">from<sub element-id="289">i</sub>&nbsp;</strong>and <strong element-id="288">to<sub element-id="287">i</sub></strong>, and given the integer <strong element-id="286">distanceThreshold</strong>. You need to find out a city with the <strong element-id="285">smallest number </strong>of cities that are reachable through some path and whose distance is&nbsp;<strong element-id="284">at most</strong>&nbsp;<strong element-id="283">Threshold Distance.</strong>&nbsp;If there are multiple such cities, our answer will&nbsp;be the city with the <strong element-id="282">greatest label</strong>.</span></p>
<p element-id="281"><span style="font-size: 18px;" element-id="280"><strong element-id="279">Note:</strong> The distance of a path connecting cities <em element-id="278"><strong element-id="277">i</strong></em>&nbsp;and&nbsp;<em element-id="276"><strong element-id="275">j</strong></em> is equal to the sum of the edge's weights along that path.</span></p>
<p element-id="274"><strong element-id="273"><span style="font-size: 18px;" element-id="272">Example 1:</span></strong></p>
<pre element-id="271"><strong element-id="270"><span style="font-size: 18px;" element-id="269">Input:</span></strong>
<span style="font-size: 18px;" element-id="268">n = 4, m = 4</span>
<span style="font-size: 18px;" element-id="267">edges = [[0, 1, 3],<br element-id="266">         [1, 2, 1], <br element-id="265">         [1, 3, 4],  <br element-id="264">         [2, 3, 1]]</span>
<span style="font-size: 18px;" element-id="263">distanceThreshold = 4</span>
<strong element-id="262"><span style="font-size: 18px;" element-id="261">Output:<br element-id="260"></span></strong><span style="font-size: 18px;" element-id="259">3</span>
<strong element-id="258"><span style="font-size: 18px;" element-id="257">Explaination:<br element-id="256"><img src="https://media.geeksforgeeks.org/img-practice/PROD/addEditProblem/711146/Web/Other/db9aa4c2-8a65-4b18-b6ad-7034096be600_1684840736.png" width="305" height="296" element-id="255"><br element-id="254"></span></strong><span style="font-size: 18px;" element-id="253">The neighboring cities at a distanceThreshold = 4 for each city are:
City 0 -&gt; [City 1, City 2]&nbsp;
City 1 -&gt; [City 0, City 2, City 3]&nbsp;
City 2 -&gt; [City 0, City 1, City 3]&nbsp;
City 3 -&gt; [City 1, City 2]&nbsp;
Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.</span>
</pre>
<p element-id="252"><strong element-id="251"><span style="font-size: 18px;" element-id="250">Example 2:</span></strong></p>
<pre element-id="249"><strong element-id="248"><span style="font-size: 18px;" element-id="247">Input:&nbsp;</span></strong><span style="font-size: 18px;" element-id="246"><span style="font-size: 18px;" element-id="245"><br element-id="244">n = 5, m = 6<br element-id="243">edges = [[0, 1, 2],
         [0, 4, 8],<br element-id="242">         [1, 2, 3], <br element-id="241">         [1, 4, 2], <br element-id="240">         [2, 3, 1],<br element-id="239">         [3, 4, 1]]<br element-id="238">distanceThreshold = 2.<br element-id="237"></span></span><span style="font-size: 18px;" element-id="236"><strong style="font-size: 18px;" element-id="235">Output:<br element-id="234"></strong><span style="font-size: 18px;" element-id="233">0<br element-id="232"></span><strong style="font-size: 18px;" element-id="231">Explaination:<br element-id="230"><img src="https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/711146/Web/Other/blobid0_1709737447.png" width="310" height="273" element-id="229"></strong><br element-id="228"><span style="font-size: 18px;" element-id="227">The neighboring cities at a distanceThreshold = 2 for each city are:
City 0 -&gt; [City 1] 
City 1 -&gt; [City 0, City 4] 
City 2 -&gt; [City 3, City 4] 
City 3 -&gt; [City 2, City 4]
City 4 -&gt; [City 1, City 2, City 3] 
The city 0 has 1 neighboring city at a distanceThreshold = 2.<br element-id="226"></span></span></pre>
<p element-id="225"><strong element-id="224"><span style="font-size: 18px;" element-id="223">Your Task:</span></strong><br element-id="222"><span style="font-size: 18px;" element-id="221">You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong element-id="220">findCity( )&nbsp;</strong>which takes a number of nodes <strong element-id="219">n, </strong>total number of edges <strong element-id="218">m</strong>&nbsp;and vector of <strong element-id="217">edges</strong> and <strong element-id="216">distanceThreshold</strong>. and return the city with the smallest number of cities that are reachable through some path and whose distance is <strong element-id="215">at most</strong> Threshold Distance. If there are multiple such cities, return the city with the greatest label.</span></p>
<p element-id="214"><span style="font-size: 18px;" element-id="213"><strong element-id="212">Expected Time Complexity:&nbsp;</strong>O(n<sup element-id="211">2</sup> + length(edges)*nlog(n) )</span><br element-id="210"><span style="font-size: 18px;" element-id="209"><strong element-id="208">Expected Auxiliary Space:&nbsp;&nbsp;</strong>O(n<sup element-id="207">3</sup>)</span></p>
<p element-id="206"><span style="font-size: 18px;" element-id="205"><strong element-id="204">Constraints:</strong><br element-id="203">1&nbsp; ≤&nbsp; n ≤&nbsp; 100<br element-id="202">1 &lt;= m &lt;= n*(n-1)/2<br element-id="201">length(edges[i]) == 3<br element-id="200">0 &lt;= from<sub element-id="199">i&nbsp;</sub>&lt; to<sub element-id="198">i</sub>&nbsp;&lt; n<br element-id="197">1 &lt;= weight<sub element-id="196">i </sub>distanceThreshold &lt;= 10<sup element-id="195">4</sup><br element-id="194">All pairs (from<sub element-id="193">i</sub>, to<sub element-id="192">i</sub>) are distinct</span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Graph</code>&nbsp;<code>Shortest Path</code>&nbsp;<code>BFS</code>&nbsp;<code>Disjoint Set</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;