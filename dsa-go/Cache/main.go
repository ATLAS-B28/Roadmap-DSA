package main

import (
	"container/list"
	"fmt"
)

type LRUCache struct {
	capacity int
	cache    map[int]*list.Element
	list     *list.List
}

/*
	type LFUCache struct {
		capacity int
		cache    map[int]*list.Element
		freq     map[int]*list.List
		minFreq  int
	}

	type MFUCache struct {
		capacity int
		cache    map[int]*list.Element
		freq     map[int]*list.List
		minFreq  int
	}
*/
type Pair struct {
	key   int
	value int
}

func newLRUCache(capacity int) *LRUCache {
	return &LRUCache{
		capacity: capacity,
		cache:    make(map[int]*list.Element),
		list:     list.New(),
	}
}

func (lru *LRUCache) Get(key int) int {
	if element, ok := lru.cache[key]; ok {
		lru.list.MoveToFront(element)
		return element.Value.(*Pair).value
	}
	return -1
}

func (lru *LRUCache) Put(key, value int) {
	if element, ok := lru.cache[key]; ok {
		lru.list.MoveToFront(element)
		element.Value.(*Pair).value = value
	} else {
		if len(lru.cache) >= lru.capacity {
			back := lru.list.Back()
			delete(lru.cache, back.Value.(*Pair).key)
			lru.list.Remove(back)
		}
		newPair := &Pair{key, value}
		element := lru.list.PushFront(newPair)
		lru.cache[key] = element
	}
}

func main() {
	lruCache := newLRUCache(4)

	lruCache.Put(1, 1)
	lruCache.Put(6, 2)
	lruCache.Put(5, 5)
	lruCache.Put(4, 4)

	fmt.Println(lruCache.Get(1))
	fmt.Println(lruCache.Get(2))
	fmt.Println(lruCache.Get(3))
	fmt.Println(lruCache.Get(4))
}
