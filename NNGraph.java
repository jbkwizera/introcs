public class NNGraph {
	public static Graph eval(int N) {
		Graph G = new Graph();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				String E = String.format("%d%d", i,   j);
				String T = String.format("%d%d", i-1, j);
				String D = String.format("%d%d", i+1, j);
				String R = String.format("%d%d", i, j+1);
				String L = String.format("%d%d", i, j-1);

				if 		(i == 0) {
					G.addEdge(E, D);
					if 		(j == 0)		{ G.addEdge(E, R);	}  	//D R
					else if 	(j == N-1)	{ G.addEdge(E, L);	}	//D L
					else	{ G.addEdge(E, L); G.addEdge(E, R);	}	//D L R
				}
				else if (j == 0) {
					G.addEdge(E, R);
					if 		(i == 0)		{ G.addEdge(E, D);	}	//R D
					else if 	(i == N-1)	{ G.addEdge(E, T);	}	//R T
					else	{ G.addEdge(E, T); G.addEdge(E, D);	}	//R T D
				}
				else if (i == N-1) {
					G.addEdge(E, T);
					if 		(j == 0)		{ G.addEdge(E, R);	}	//T R
					else if 	(j == N-1)	{ G.addEdge(E, L); 	}	//T L
					else { G.addEdge(E, L); G.addEdge(E, R);	}	//T L R
				}
				else if (j == N-1) {
					G.addEdge(E, L);
					if 		(i == 0)		{ G.addEdge(E, D);	}	//L D
					else if 	(i == N-1)	{ G.addEdge(E, T);	} 	//L T
					else { G.addEdge(E, T); G.addEdge(E, D);	}	//L T D
				}
				else if (j > 0 && i > 0 && i < N-1 && j < N-1) {
					G.addEdge(E, T);
					G.addEdge(E, D);
					G.addEdge(E, R);
					G.addEdge(E, L);
				}
			}
		}
		return G;
	}
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		Graph G = eval(N);
		StdOut.print(G);
	}
}
