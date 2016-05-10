(

var nbPiste=2;

w=Window("window title", Rect(0, 0, 400, 400));
a=ScaledView(w, w.bounds)
.mouseMoveAction_{arg self, x, y;
	y.postln;
self.drawFunc_{ Pen.fillRect(
Rect(x, y, self.defSize.x, self.defSize.y))};
	self.refresh
};
a.defSize_(1@(a.bounds.height/nbPiste));
w.front;


)