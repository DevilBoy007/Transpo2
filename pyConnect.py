import cgi, cgitb
import sqlite3

#enable cgi and initialize supporting directories
cgitb.enable()
from flask import Flask, escape, request, redirect
app = Flask(__name__)
#@app.route waits for a ping from the local server '/'
#it is set up to interact with GET and POST methods
@app.route('/', methods=['GET','POST'])
#main method that runs when the server is pinged
def main():
#create a cgi object to parse submitted form
    form = cgi.FieldStorage()
#create variables to store form fields to using the req get method
#get method looks for form field with matching name, refer to index.html form
    ticket = request.form.get('ticket')
    fname = request.form.get('fname')
    lname = request.form.get('lname')
    deptCity = request.form.get('deptCity')
    deptTime = request.form.get('deptTime')
    door = request.form.get('door')
    gate = request.form.get('gate')
    carryOn = request.form.get('carryOn')
    carry = False
    if(carryOn == "yes"):
        carry=True
    cargo = request.form.get('cargo')
    car = False
    if(cargo=="yes"):
        car = True
#open db connection
    db = sqlite3.connect('/Users/dbakr/Desktop/airport stuff/airport.db')
#create placeholders (SQL injection)
    sqTicket = '{}'.format(ticket)
    sqFname = '{}'.format(fname)
    sqLname = '{}'.format(lname)
    sqCity = '{}'.format(deptCity)
    sqTime = '{}'.format(deptTime)
    sqDoor = '{}'.format(door)
    sqGate = '{}'.format(gate)
    sqCarryOn = '{}'.format(carry)
    sqCargo = '{}'.format(car)
#create SQL query to store data values into associated database columns using placeholders to prevent against SQL injection
    injSQL = "INSERT INTO airport (ticket,fname,lname,deptCity, deptTime, door, gate, carryOn, cargo) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s')" % (sqTicket,sqFname,sqLname,sqCity,sqTime,sqDoor, sqGate, sqCarryOn, sqCargo)
#exectue SQL query on database, commit it, then close connection
    db.execute(injSQL)
    db.commit()
    db.close()
#   return redirect("./evaSite.html", code=302) once the site is live, redirect will not work for local site
    return "Please wait while we generate your itinerary..."

# if __name__ == '__main__':
#     # Bind to PORT if defined, otherwise default to 5000.
#     port = int(os.environ.get('PORT', 5000))
#     app.run(host='0.0.0.0', port=port)
