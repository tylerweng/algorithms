def derangement(vs):
    l = [None for x in vs]
    sol = set()
    sol.add(tuple(l))
    for v in vs:
        sol1 = set()
        for s in sol:
            for (i, v1) in enumerate(s):
                if not v1 and v != vs[i]:
                    s1 = list(s)
                    s1[i] = v
                    sol1.add(tuple(s1))
        sol = sol1
    return list(sol)
