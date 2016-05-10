


ScaledView(nil, 200@200)
.mouseMoveAction_{arg self, x, y; 
[x, y].postln; 
self.drawFunc_{ Pen.fillRect(
Rect(x, y, self.defSize.x, self.defSize.y))};
self.refresh
}.front


	ScaledView(nil, 500@500)
	.roundationF_{ arg x, y;
	[ x.round(50), y ]
	}
	.mouseMoveAction_{
	arg self, x, y;
	[x, y].postln;
	Button(self, Rect(x, y, 150, 150))
	}.front


	a=r{ arg points;
	var now=0;
p	var current=thisThread.beats;
	r=Pwhite(50,250).asStream; n=r.next;
	points=[ points[0].round(n), points[1] ].yield;
	loop{
	now=thisThread.beats;
	if(now > (current+4))
	{ n=r.next;
	current=thisThread.beats};
	points=[ points[0].round(n), points[1] ].yield;
	}
	};
	ScaledView(nil, 500@500)
	.roundationF_{ arg x, y;
	[x, y].postln ;
	a.next([x, y]).postln
	}
	.mouseMoveAction_{
	arg self, x, y;
	[x, y].postln;
	Button(self, Rect(x, y, 150, 150))
	}.front


