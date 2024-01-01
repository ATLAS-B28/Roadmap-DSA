package main

import (
	"fmt"
	"io"
	"os"
)

func writeFile(filename, content string) error {
	file, err := os.Create(filename)
	if err != nil {
		return err
	}
	defer file.Close()

	_, err = io.WriteString(file, content)
	return err
}

func openFile(filename string) ([]byte, error) {
	file, err := os.Open(filename)
	if err != nil {
		return nil, err
	}
	defer file.Close()

	stat, err := file.Stat()

	if err != nil {
		return nil, err
	}

	data := make([]byte, stat.Size())
	_, err = file.Read(data)
	return data, err
}

func main() {
	filename := "example.txt"
	content := "Hello, world, this is Aditya Bhambere"

	err := writeFile(filename, content)

	if err != nil {
		fmt.Println("Error writing file:", err)
		return
	}

	fmt.Println("File written successfully.")

	data, err := openFile(filename)
	if err != nil {
		fmt.Println("Error opening file:", err)
		return
	}
	fmt.Println("File Content: ", string(data))
}
