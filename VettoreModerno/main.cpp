using	namespace	std;
bool	elementoPresente	(int	elem,	vector<int>	v)
{
    int	dim=	v.size();
    for(int	i=0;	i<	dim;	i++)
    {
        if	(v[i]==	elem)	return	true;
    }
    return	false;
}
void	mostraVettore(const	vector<int>	&	v	)
{
    int	dim=	v.size();
    cout	<<	"contenuto	vettore:	"	<<		endl;
    for(int	i=0;	i<	dim;	i++)
    {
        cout	<<	v[i]	<<"		";
    }
    cout	<<	endl	<<	endl;
}
vettori.cpp 2
vector<int>	elementiComuniNonRipetuti(	const	vector<int>	&	va	,const	vector<int>	&	vb	)
{
    int	la=	va.size();
    vector<int>	vr;
    for(	int	i=0;	i<	la;	i++	)
        if	(	elementoPresente(	va[i],	vb	)	&&	!	elementoPresente(	va[i],	vr)	)
            vr.push_back(va[i]);
    return	vr;
}
void main()
{
    srand(13);
    const	int	N	=	15;
    vector<int>	va;
    riempiVettoreAcaso(	va,	N	);
    vector<int>	vb;
    riempiVettoreAcaso(	vb,	N+2	);
    mostraVettore(va);
    mostraVettore(vb);
    vector<int>	vc	=	elementiComuniNonRipetuti(va,	vb);
    mostraVettore(vc);
}
