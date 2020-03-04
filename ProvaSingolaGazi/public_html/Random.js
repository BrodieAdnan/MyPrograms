function Random(n) {
	for (var i = 0; i < 90; i++) {
		var rand = Math.floor(Math.random() * 90);
		var appoggio = n[i];
		n[i] = n[rand];
		n[rand] = appoggio;
	}
	return n;
}

