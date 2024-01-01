package main

import (
	"html/template"
	"net/http"
)

type Person struct {
	Name string
	Age  int
}

func main() {
	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		person := Person{Name: "Aditya", Age: 21}

		tmpl := template.New("template.html")
		tmpl, err := tmpl.ParseFiles("template.html")

		if err != nil {
			http.Error(w, err.Error(), http.StatusInternalServerError)
			return
		}

		err = tmpl.Execute(w, person)
		if err != nil {
			http.Error(w, err.Error(), http.StatusInternalServerError)
		}
	})
	http.ListenAndServe(":8080", nil)
}
